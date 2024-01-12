plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
}

android {
    val javaVersion = JavaVersion.VERSION_17
    namespace = "com.deerangle.notion.todo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.deerangle.notion.todo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://api.notion.com/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"https://api.notion.com/\"")
        }
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }
}

dependencies {
    // Android
    implementation(libs.android.core.ktx)
    implementation(libs.android.appcompat)
    implementation(libs.bundles.feature.ui)

    // Dagger Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)

    // Retrofit + OkHttp
    implementation(libs.bundles.retrofit)

    // Notion SDK
    implementation(libs.notion.sdk)

    // Tests
    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockito.core)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.test.espresso.core)
}
