plugins {
    id("buildlogic.quarkus-conventions")
    application
}

dependencies {
    implementation("io.quarkus:quarkus-info")
    implementation("io.quarkus:quarkus-hibernate-validator")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    implementation("io.quarkus:quarkus-rest-jackson")
    implementation("io.quarkus:quarkus-smallrye-health")
    implementation(project(":context1").capabilities {
        requireCapability("org.example.one:context1-hexagon:1.0.0-SNAPSHOT")
    })
    implementation(project(":context1").capabilities {
        requireCapability("org.example.one:context1-infrastructure:1.0.0-SNAPSHOT")
    })
    implementation(project(":context2").capabilities {
        requireCapability("org.example.one:context2-hexagon:1.0.0-SNAPSHOT")
    })
}

group = "org.example"
version = "1.0.0-SNAPSHOT"

application {
    mainClass = "App"
}
