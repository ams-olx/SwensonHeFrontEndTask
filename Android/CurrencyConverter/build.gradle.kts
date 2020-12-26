// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val kotlin_version by extra("1.4.20")
    repositories {
        google()
        maven { url = uri(Repositories.jitpack) }
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = Gradle.versions.kotlinVersion))
        classpath ("com.android.tools.build:gradle:${Gradle.versions.gradle}")
        classpath ("org.koin:koin-gradle-plugin:${Gradle.versions.koin}")
        classpath ("com.google.gms:google-services:${Gradle.versions.gmsPlugin}")
    }
}

allprojects {
    repositories {
        google()
        maven { url = uri(Repositories.jitpack) }
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}