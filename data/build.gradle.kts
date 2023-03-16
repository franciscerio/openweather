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
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":network"))
    implementation(project(":local"))

    implementation(Google.HILT)
    kapt(Google.HILT_COMPILER)
}