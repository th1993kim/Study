package com.example.telemetry.persistence

import org.springframework.data.jpa.repository.JpaRepository
import com.example.telemetry.persistence.entity.TelemetryEventEntity

interface TelemetryEventRepository : JpaRepository<TelemetryEventEntity, Long>