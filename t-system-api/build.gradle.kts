plugins {
    id("com.android.library")
    id("maven-publish")
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



group = "com.ttt.api"
version = "1.0.0-T"
val githubProjectName = "T-System"


publishing {
    publications {
        create<MavenPublication>("ReleaseAar") {
            groupId = "com.ttt.api"
            artifactId = "T-System"
            version = "1.0.0-T"

            pom {
                url.set("https://github.com/PoT-datas/$githubProjectName")
                name.set(githubProjectName)
                description.set(
                    """
                        A library for terminal system control
                        Visit the project on GitHub to learn more.
                        """.trimIndent()
                )
                inceptionYear.set("2023")
                licenses {
                    license {
                        name.set("Apache-2.0 License")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("ttt")
                        name.set("Olivier Tambo")
                        url.set("https://ttt.com/")
                        email.set("olivierdhon@gmail.com")
                        roles.set(listOf("Lead Developer"))
                        timezone.set("GMT+2:00")
                    }
                }
                contributors {
                    // contributor {}
                }
                scm {
                    tag.set("HEAD")
                    url.set("https://github.com/PoT-datas/$githubProjectName")
                    connection.set("scm:git:github.com/PoT-datas$githubProjectName.git")
                    developerConnection.set("scm:git:ssh://github.com/PoT-datas/$githubProjectName.git")
                }
                issueManagement {
                    system.set("GitHub")
                    url.set("https://github.com/PoT-datas/$githubProjectName/issues")
                }
                ciManagement {
                    system.set("GitHub Actions")
                    url.set("https://github.com/PoT-datas/$githubProjectName/actions")
                }
            }

            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
        }
    }
    repositories {
        mavenLocal()
    }
}