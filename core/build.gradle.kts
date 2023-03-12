@file:Suppress("UnstableApiUsage")

import com.fcerio.module.plugins.Google
import com.fcerio.module.plugins.Config
import com.fcerio.module.plugins.ThirdParty

plugins {
    id("com.android.library")
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
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    kapt(Google.HILT_COMPILER)

    api(Google.CORE_KTX)
    api(ThirdParty.TIMBER)
    api(Config.KOTLIN_STDLIB)
    api(Google.COROUTINE_CORE)
    api(Google.COROUTINE_ANDROID)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}