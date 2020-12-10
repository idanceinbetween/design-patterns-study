import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
    java // Required by at least JUnit.
}
group = "co.idanceinbetween"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.code.gson:gson:2.8.6")

    testImplementation(kotlin("test-junit5"))

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
application {
    mainClassName = "MainKt"
}
tasks {
    test {
        useJUnitPlatform()
    }
}
