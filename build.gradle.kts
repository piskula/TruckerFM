import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.23"
}

allprojects {
    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}

subprojects {
    group = "sk.momosilabs.trucker"
    version = "1.0.0-SNAPSHOT"

    apply {
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }
}
repositories {
  mavenCentral()
}

dependencies {
    platform("org.springframework.boot:spring-boot-dependencies:3.2.4.RELEASE")
}
