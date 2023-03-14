@file:Suppress("UnstableApiUsage")

import com.fcerio.module.plugins.Config
import com.fcerio.module.plugins.AndroidX
import com.fcerio.module.plugins.ThirdParty
import com.fcerio.module.plugins.Google
import java.util.Properties

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
        getByName("release") {
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core"))

    api(AndroidX.APP_COMPAT)
    api(AndroidX.CONSTRAINT_LAYOUT)
    api(AndroidX.COORDINATOR_LAYOUT)
    api(AndroidX.ACTIVITY_KTX)
    api(AndroidX.FRAGMENT_KTX)

    api(ThirdParty.GLIDE)
    kapt(ThirdParty.GLIDE_COMPILER)

    api(AndroidX.VIEW_MODEL_KTX)
    implementation(Google.MATERIAL)
    implementation(Google.HILT)
    kapt(Google.HILT_COMPILER)
}