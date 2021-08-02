import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    runtimeOnly("io.r2dbc:r2dbc-postgresql")
    implementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    // https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api
    implementation("jakarta.validation:jakarta.validation-api:3.0.0")
    implementation("io.github.cdimascio:openapi-spring-webflux-validator:3.4.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-log4j2
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    // https://mvnrepository.com/artifact/org.flywaydb/flyway-core
    implementation("org.flywaydb:flyway-core:7.12.0")

}

configurations {
    all {
        exclude("org.springframework.boot", "spring-boot-starter-logging")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
