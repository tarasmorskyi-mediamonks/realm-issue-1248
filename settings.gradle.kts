
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
        // Only required for realm-kotlin snapshots
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        // Only required for realm-kotlin snapshots
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "My_Application"
include(":androidApp")
include(":shared")