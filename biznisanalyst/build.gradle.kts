plugins {
    id ("java-conventions")
    alias(libs.plugins.spring.framework)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.graalvm)
    alias(libs.plugins.lombok)
}

dependencies {
    implementation(libs.guava)
    implementation(libs.spring.starter.web)
    implementation(libs.spring.starter.webflux)
    implementation(libs.spring.starter.security)
    implementation(libs.spring.doc.openapi.ui)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.mockito.core)
    testImplementation(libs.spring.starter.test)
}
