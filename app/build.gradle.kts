plugins {
    // Kotlin support is built into AGP 9 - the kotlin-android plugin is no longer applied.
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.orbitalsonic.generalproject"

    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.orbitalsonic.generalproject"
        minSdk = 24
        targetSdk = 37
        versionCode = 133
        versionName = "3.6.133"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    bundle {
        language {
            enableSplit = false
        }
    }

    buildTypes {
        release {
            // Replaces isMinifyEnabled + isShrinkResources + proguardFiles.
            // Custom keep rules live in app/src/main/keepRules/
            optimization {
                enable = true
                keepRules {
                    // Equivalent of getDefaultProguardFile("proguard-android-optimize.txt")
                    includeDefault = true
                }
            }
        }
        debug {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.gson)

    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)

    implementation(libs.androidx.work.runtime.ktx)

    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.process)

    implementation(libs.kotlinx.coroutines.android)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.common)
    implementation(libs.firebase.config)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

    implementation(libs.koin.android)

    implementation(libs.glide)

    implementation(libs.play.services.location)

    implementation(libs.androidx.core.splashscreen)

    implementation(libs.lottie)
}
