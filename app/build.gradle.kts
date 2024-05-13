import com.android.build.api.dsl.Packaging

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    jacoco
    id("org.jetbrains.kotlinx.kover") version "0.7.5"
    // use JUnit5 for tests
    //id("de.mannodermaus.android-junit5") version "1.10.0.0"
}
koverReport {
    filters {
        excludes {
            classes("com.baeldung.code.not.covered")
        }
    }

    verify {
        rule {
            isEnabled = true
            bound {
                //minValue = 80 // Minimum coverage percentage
            }
        }
    }
}
jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

android {
    namespace = "com.example.honkaicard"
    compileSdk = 34
//    fun Packaging.() {
//        resources.excludes.add("META-INF/*")
//    }
    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",

        )
        )
    }
    defaultConfig {
        applicationId = "aaa.example.honkaicard"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = true

        }
        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildToolsVersion = "34.0.0"
}
java{
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
//test{
//    useJUnitPlatform()
//}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("junit:junit:4.12")

    androidTestImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.mockito:mockito-inline:3.11.2")

//    testImplementation(kotlin("test"))
//    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
//    //testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
//// (Required) Writing and executing Unit Tests on the JUnit Platform
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
//
//    // (Optional) If you need "Parameterized Tests"
//    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
//
//    // (Optional) If you also have JUnit 4-based tests
//    testImplementation("junit:junit:4.13.2")
//    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.10.0")

}
