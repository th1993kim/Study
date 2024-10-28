import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.dsl.SpringBootExtension
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    java
    id("org.springframework.boot") version "3.3.4" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
}

group = "org.codingdreamtree"
version = "0.0.1-SNAPSHOT"

allprojects {
    tasks.withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}

repositories {
    mavenCentral()
}
subprojects {
    apply {
        plugin("java-library")
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    repositories {
        mavenCentral()
    }

    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.getByName<BootRun>("bootRun") {
        enabled = false
    }
}
dependencies {

}

tasks.withType<Test> {
    useJUnitPlatform()
}
