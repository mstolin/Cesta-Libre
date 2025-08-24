plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "to.marcel.libre.core.datastore"
    compileSdk = 36
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

dependencies {
    api(project(":core:model"))
    implementation(libs.androidx.datastore.core)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}