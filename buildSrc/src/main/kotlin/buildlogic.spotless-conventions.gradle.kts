import com.diffplug.spotless.extra.wtp.EclipseWtpFormatterStep.XML
import org.eclipse.jgit.api.Git
import org.eclipse.jgit.transport.RefSpec
import org.eclipse.jgit.transport.URIish
import java.net.URI

plugins {
    id("com.diffplug.spotless")
}

spotless {
    isEnforceCheck = false
    java {
        removeUnusedImports()
        importOrder("java", "jakarta", "javax", "\\#")
        endWithNewline()
        eclipse().configFile("buildSrc/src/main/resources/eclipse-java-formatter.xml")
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        targetExclude("**/build/**")
        ktlint()
    }
    json {
        target("src/**/*.json")
        targetExclude("**/build/**")
        simple()
    }
    yaml {
        target("**/*.yaml")
        targetExclude("**/build/**", "tooling/**")
        jackson()
    }
    sql {
        target("**/*.sql")
        targetExclude("**/build/**")
        prettier()
    }
    format("xml") {
        target("**/*.xml")
        targetExclude(
            "**/build/**",
            ".idea/**",
            "**/eclipse-java-formatter.xml",
            "**/jacoco.xml",
        )
        eclipseWtp(XML)
    }
}
tasks.register("spotlessCommit") {
    doLast {
        val git = Git.open(projectDir)
        val status = git.status().call()
        if (status.hasUncommittedChanges()) {
            git.add().addFilepattern(".").call()
            git.commit().setMessage("\uD83C\uDFA8Apply spotless formatting").setAuthor("spotless", "spotless@no.op")
                .call()
        }
    }
}

tasks.register("spotlessPush") {
    doLast {
        val git = Git.open(projectDir)
        val thereIsNothingToPush = !git.log().call().iterator().hasNext()
        if (thereIsNothingToPush) {
            return@doLast
        }
        val accessToken = System.getenv("spotless_commit_ci")
        requireNotNull(accessToken) { "The SPOTLESS_COMMIT_CI environment variable is not set" }
        addRemoteIfMissing(git, accessToken)
        val branchName = System.getenv("CI_COMMIT_REF_NAME")
        git.push().setRemote("spotless").setRefSpecs(RefSpec("HEAD:$branchName")).setPushOptions(listOf("ci.skip")).call()
    }
}

fun addRemoteIfMissing(
    git: Git,
    accessToken: String,
) {
    if (git.remoteList().call().none { it.name == "spotless" }) {
        git.remoteAdd().setUri(
            URIish(
                URI("https://spotless_commit_ci:$accessToken@gitlab.prod.aws.wescale.fr/wescalefr/weshare/weshare-services.git")
                    .toURL(),
            ),
        ).setName("spotless").call()
    }
}
