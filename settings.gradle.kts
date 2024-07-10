plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "one"
include(
    "app",
    "context1",
    "context2",
)
