plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.plugin.spotless)
    implementation(libs.jgit)
    implementation(libs.plugin.quarkus)
}
