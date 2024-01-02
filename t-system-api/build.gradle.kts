plugins {
    /**id("com.android.library")
    ///---id("kotlin-android")
    ///+id("org.jetbrains.dokka") version "1.6.21"
    ///+id("jacoco")
    id("maven-publish")
    // To generate signature and checksum files for each artifact
    id("signing")
    // To print beautiful logs on the console while running tests with Gradle
    // Doesn't work for Android instrumented tests
    id("com.adarshr.test-logger") version "3.0.0*/

    id("com.android.library")
    id("maven-publish")
}


group = "api.ttt.android"
version = "1.0.0-T"
val githubProjectName = "T-System"


publishing {
    publications {
        /**create<MavenPublication>("mavenJava") {
            from(components["java"])
        }*/
        create<MavenPublication>("ReleaseAar") {
            groupId = "api.ttt.android"
            artifactId = "t-system-api"
            version = "1.0.0-T"
            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
        }
    }
    repositories {
        mavenLocal()
    }
}


android {
    namespace = "api.ttt.system"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }

        singleVariant("debug") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
