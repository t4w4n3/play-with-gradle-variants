plugins {
    id("buildlogic.java-conventions")
    id("io.quarkus")
}

dependencies {
    implementation(enforcedPlatform(libs("quarkus.bom")))
    implementation("io.quarkus:quarkus-arc")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}
tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    jvmArgs("-Xshare:off", "-XX:+EnableDynamicAgentLoading")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
