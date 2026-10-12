package com.ronbodnar.vehicletelemetry.listener;

import com.ronbodnar.vehicletelemetry.domain.EnrichedVehicleTelemetry;
import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;
import com.ronbodnar.vehicletelemetry.service.TelemetryEnrichmentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VehicleTelemetryListener {

    private final TelemetryEnrichmentService telemetryEnrichmentService;

    public VehicleTelemetryListener(TelemetryEnrichmentService telemetryEnrichmentService) {
        this.telemetryEnrichmentService = telemetryEnrichmentService;
    }

    @KafkaListener(id="telemetryListener", topics = "vehicle-telemetry")
    public void listen(VehicleTelemetryEvent telemetryEvent) {
        log.info("Received an event: {}", telemetryEvent);

        EnrichedVehicleTelemetry enrichedTelemetry = telemetryEnrichmentService.enrich(telemetryEvent);

        log.info("EnrichedVehicleTelemetry: {}", enrichedTelemetry);
    }
}
