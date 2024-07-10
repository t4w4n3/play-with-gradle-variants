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
        capability("${project.group}", "${project.name}-hexagon", "${project.version}")
    }
    registerFeature(infrastructure.name) {
        usingSourceSet(infrastructure)
        capability("${project.group}", "${project.name}-infrastructure", "${project.version}")
    }
}

dependencies {
    "infrastructureImplementation"(hexagon.output)
}
