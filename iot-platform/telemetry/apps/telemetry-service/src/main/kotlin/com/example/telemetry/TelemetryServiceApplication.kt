package com.example.telemetry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class TelemetryServiceApplication

fun main(args: Array<String>) {
    runApplication<TelemetryServiceApplication>(*args)
}