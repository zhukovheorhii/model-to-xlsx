import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies{
    implementation("io.github.millij:poi-object-mapper:1.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}