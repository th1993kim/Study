package com.example.telemetry.ops

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.Instant


@Component
class LogstashClient (
    @Value("\${app.logstash.url}") private val logstashUrl: String
){
    private val webClient = WebClient.builder().build()


    fun info(service: String, message: String, fields: Map<String, Any?> = emptyMap()) {
        val body = mutableMapOf<String, Any?> (
            "com/example/telemetry/servicemple/telemetry/service" to service,
            "env" to "local",
            "level" to "INFO",
            "message" to message,
            "ts" to Instant.now().toString()
        )

        body.putAll(fields)

        webClient.post()
            .uri(logstashUrl)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .toBodilessEntity()
            .onErrorResume { _ -> Mono.empty()}
            .subscribe()
    }
}