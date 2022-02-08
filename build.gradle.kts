buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
                as org.gradle.accessors.dm.LibrariesForLibs

        classpath(libs.bundles.gradlePlugins)
        classpath(kotlin("gradle-plugin", libs.versions.kotlin.get()))
        classpath(libs.gradlePlugin.graphql)
        classpath(libs.gradlePlugin.molecule)
        classpath(libs.gradlePlugin.anvil)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
