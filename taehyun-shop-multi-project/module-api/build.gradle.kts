plugins {
    id("java")
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":module-core"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.projectlombok:lombok")

    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    annotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}