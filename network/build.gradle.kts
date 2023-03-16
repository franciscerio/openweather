@file:Suppress("UnstableApiUsage")

import com.fcerio.module.plugins.Google
import com.fcerio.module.plugins.Config
import com.fcerio.module.plugins.ThirdParty
import java.util.Properties

plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.COMPILE_SDK_VERSION
    buildToolsVersion = Config.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        all {
            getProps(rootProject.file("dependencies.properties")).forEach { prop ->
                buildConfigField("String", prop.key.toString(), prop.value.toString())
            }
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))

    implementation(ThirdParty.RETROFIT)
    implementation(ThirdParty.RETROFIT_GSON)
    implementation(ThirdParty.RETROFIT_SCALAR)

    implementation(ThirdParty.OKHTTP)
    implementation(ThirdParty.OKHTTP_INTERCEPTOR)

    implementation(Google.HILT)
    kapt(Google.HILT_COMPILER)
}

fun getProps(file: File): Properties {
    val props = Properties()
    props.load(file.inputStream())
    return props
}
