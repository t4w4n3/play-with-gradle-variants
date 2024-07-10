plugins {
    java
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(libs("test.junit"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(version("java"))
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    reports.html.required = false
    reports.junitXml.required = System.getenv("CI") == "true"
    if (System.getenv("CI") != "true") {
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
        }
    }
}
