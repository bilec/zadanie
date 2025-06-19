plugins {
  id("java-conventions")
  alias(libs.plugins.spring.framework)
  alias(libs.plugins.spring.dependency.management)
  alias(libs.plugins.graalvm)
  alias(libs.plugins.lombok)
}

dependencies {
  implementation(libs.commons.text)
  implementation(libs.guava)
  implementation(libs.spring.starter.web)
  implementation(libs.spring.doc.openapi.ui)

  testImplementation(platform(libs.junit.bom))
  testImplementation(libs.junit.jupiter)
  testImplementation(libs.mockito.core)
  testImplementation(libs.spring.starter.test)
}

graalvmNative {
  binaries {
    named("main") {
      buildArgs.add("--no-fallback")
      buildArgs.add("--report-unsupported-elements-at-runtime")
    }
  }
}
