plugins {
    id("buildlogic.java-conventions")
}
group = "org.example.one"
version = "1.0.0-SNAPSHOT"

val hexagon: SourceSet by sourceSets.creating
val infrastructure: SourceSet by sourceSets.creating

java {
    registerFeature(hexagon.name) {
        usingSourceSet(hexagon)
    }
    registerFeature(infrastructure.name) {
        usingSourceSet(infrastructure)
    }
}

dependencies {
    "infrastructureImplementation"(hexagon.output)
    "hexagonImplementation"(project(":context1").capabilities {
        requireCapability("org.example.one:context1-hexagon:1.0.0-SNAPSHOT")
    })
}
