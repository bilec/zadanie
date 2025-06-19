plugins {
    java
    id("com.diffplug.spotless")
}

repositories {
    mavenCentral()
}

spotless {
    java {
        googleJavaFormat("1.24.0")
        targetExclude("**/build/**")
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
