plugins {
    java
    jacoco
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
        csv.required = false
        html.required = false
    }
    dependsOn(tasks.check)
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "METHOD"
            includes =
                listOf(
                    "fr.wescale.weshare.domain.*",
                    "fr.wescale.weshare.application.adapters.**",
                )
            excludes =
                listOf(
                    "*equals*",
                    "*hashCode*",
                )
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "1.0".toBigDecimal() // Decrease only when you have a good reason
            }
        }
    }
}
