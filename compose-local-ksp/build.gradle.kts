import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.ext["compose_version"]}")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.4.32-1.0.0-alpha07")
    implementation("com.squareup:kotlinpoet:1.8.0")
    api(project(":compose-local-ksp-api"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}