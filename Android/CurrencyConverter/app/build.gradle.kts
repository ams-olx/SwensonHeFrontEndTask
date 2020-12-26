import Gradle.buildConfig

plugins {
    id("com.android.application")
    kotlin(Gradle.plugins.android)
    kotlin(Gradle.plugins.androidExtensions)
    kotlin(Gradle.plugins.kapt)
    id("kotlin-android")
}

android {

    compileSdkVersion(Versions.compileSdk)
    ndkVersion = Gradle.versions.ndk

    packagingOptions {
        exclude ("META-INF/DEPENDENCIES")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/LICENSE.txt")
        exclude ("META-INF/license.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/ASL2.0")
        exclude ("META-INF/project.properties")
        exclude ("META-INF/MANIFEST.MF")
        exclude ("META-INF/rxjava.properties")
    }

    defaultConfig {
        applicationId = "com.ams.currencyconverter"
        minSdkVersion(Gradle.versions.minSdk)
        targetSdkVersion(Gradle.versions.targetSdk)
        buildToolsVersion = Gradle.versions.buildTools
        versionCode = Gradle.build.versionCode
        versionName = Gradle.build.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions(buildConfig.serverMode)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Gradle.versions.jvmTarget
    }

    defaultConfig {
        buildConfigField(buildConfig.stringField, buildConfig.baseCountriesFlagsUrl, "\"https://restcountries.eu/rest/v2/all?fields=currencies;flag\"")
        buildConfigField(buildConfig.stringField, buildConfig.baseUrlField, "\"http://data.fixer.io/api/\"")
        buildConfigField(buildConfig.stringField, buildConfig.apiKey, "\"9447e7d84ef9e86c0cbdbaaa7e2dde09\"")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    //
    androidTestImplementation(Gradle.dependencies.testRunner)
    implementation(Gradle.dependencies.stdlib)
    implementation(Gradle.dependencies.ktxCore)
    implementation(Gradle.dependencies.appCompat)
    implementation(Gradle.dependencies.material)
    implementation(Gradle.dependencies.constraintLayout)
    implementation(Gradle.dependencies.androidDevKit)
    // Rx
    implementation(Gradle.dependencies.rxJava)
    implementation(Gradle.dependencies.rxAndroid)
    implementation(Gradle.dependencies.rxBinding)
    // Koin DI
    implementation(Gradle.dependencies.koin)
    implementation(Gradle.dependencies.koinScope)
    implementation(Gradle.dependencies.koinViewModel)
    implementation(Gradle.dependencies.koinFragment)
    //
    implementation(Gradle.dependencies.retrofitGsonAdapter)
    // Image loader
    implementation(Gradle.dependencies.coil)
    implementation(Gradle.dependencies.coilSVG)
}