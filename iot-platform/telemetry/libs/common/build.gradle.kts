plugins { kotlin("jvm") }

kotlin { jvmToolchain(21) }

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.17.2")
}