package com.example.telemetry.consume

import com.example.telemetry.model.TelemetryEventDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import com.example.telemetry.service.TelemetryStoreService
import com.fasterxml.jackson.databind.ObjectMapper

@Component
class TelemetryConsumer(
    private val storeService: TelemetryStoreService,
    private val objectMapper: ObjectMapper
) {

    @KafkaListener(topics = ["\${app.kafka.topic}"])
    fun onMessage(raw: String, ack: Acknowledgment) {
        val dto = objectMapper.readValue(raw, TelemetryEventDto::class.java)
        storeService.store(dto)
        ack.acknowledge()
    }
}