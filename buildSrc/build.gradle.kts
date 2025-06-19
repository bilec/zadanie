plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

val spotlessVersion = "7.0.4"

dependencies {
    implementation("com.diffplug.spotless:com.diffplug.spotless.gradle.plugin:$spotlessVersion")
}
