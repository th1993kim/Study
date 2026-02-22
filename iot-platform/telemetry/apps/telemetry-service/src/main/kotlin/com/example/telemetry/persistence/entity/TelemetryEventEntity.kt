package com.example.telemetry.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.Instant


@Entity
@Table(
    name = "telemetry_events",
    uniqueConstraints = [UniqueConstraint(name = "uk_event_id", columnNames = ["event_id"])],
    indexes = [Index(name = "idx_device_time", columnList = "device_id,occurred_at")]
)
class TelemetryEventEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "event_id", nullable = false, length = 36)
    var eventId: String,

    @Column(name = "device_id", nullable = false, length = 64)
    var deviceId: String,

    @Column(name = "occurred_at", nullable = false)
    var occurredAt: Instant,

    @Column(name = "trace_id", nullable = false, length = 64)
    var traceId: String,

    @Column(name = "payload_json", nullable = false, columnDefinition = "json")
    var payloadJson: String
) {
    // ✅ JPA용 기본 생성자 (플러그인 없이 직접 제공)
    protected constructor() : this(
        id = null,
        eventId = "",
        deviceId = "",
        occurredAt = Instant.EPOCH,
        traceId = "",
        payloadJson = "{}"
    )
}