package com.example.telemetry.service

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.transaction.Transactional
import com.example.telemetry.model.TelemetryEventDto
import com.example.telemetry.ops.LogstashClient
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import com.example.telemetry.persistence.TelemetryEventRepository
import com.example.telemetry.persistence.entity.TelemetryEventEntity
import java.time.Instant

@Service
class TelemetryStoreService(
    private val telemetryEventRepository: TelemetryEventRepository,
    private val objectMapper: ObjectMapper,
    private val logstashClient: LogstashClient
) {
    @Transactional
    fun store(dto: TelemetryEventDto): StoreResult {
        val occurredAt = Instant.parse(dto.occurredAt)
        val payloadJson = objectMapper.writeValueAsString(dto.payload)

        val entity = TelemetryEventEntity(
            eventId = dto.eventId,
            deviceId = dto.deviceId,
            occurredAt = occurredAt,
            traceId = dto.traceId,
            payloadJson = payloadJson
        )

        return try {
            telemetryEventRepository.save(entity)
            logstashClient.info(
                service = "telemetry-service",
                message = "stored",
                fields = mapOf(
                    "eventId" to dto.eventId,
                    "deviceId" to dto.deviceId,
                    "traceId" to dto.traceId
                )
            )
            StoreResult.SAVED
        } catch (e: DataIntegrityViolationException) {
                logstashClient.info(
                    service = "telemetry-service",
                    message = "duplicated_skipped",
                    fields = mapOf(
                        "eventId" to dto.eventId,
                        "deviceId" to dto.deviceId,
                        "traceId" to dto.traceId
                    )
                )
            StoreResult.DUPLICATE
        }
    }
}