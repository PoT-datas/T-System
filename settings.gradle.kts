pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://www.jitpack.io" )
        }
    }
}
/**buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.0")
    }
}*/

rootProject.name = "T-System"
include(":app")
include(":t-system-api")
