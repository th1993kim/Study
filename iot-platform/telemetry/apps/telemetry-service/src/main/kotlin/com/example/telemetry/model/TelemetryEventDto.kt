package com.example.telemetry.model

data class TelemetryEventDto(
    val eventId: String,
    val deviceId: String,
    val occurredAt: String,
    val traceId: String,
    val payload: Map<String, Any?> = emptyMap()
)