@file:Suppress("UnstableApiUsage")

import com.fcerio.module.plugins.Config
import com.fcerio.module.plugins.ThirdParty
import com.fcerio.module.plugins.Android
import com.fcerio.module.plugins.Google
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("kotlin-parcelize")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
}

android {
    buildFeatures {
        dataBinding = true
    }

    compileSdk = Config.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.fcerio.openweatherapp"
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION
        versionCode = Android.VERSION_CODE
        versionName = Android.VERSION_NAME
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":network"))
    implementation(project(":domain"))
    implementation(project(":common"))

    implementation("com.google.android.material:material:1.8.0")
    implementation(Google.HILT)
    kapt(Google.HILT_COMPILER)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
