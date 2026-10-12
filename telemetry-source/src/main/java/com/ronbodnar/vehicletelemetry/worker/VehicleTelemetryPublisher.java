package com.ronbodnar.vehicletelemetry.worker;

import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;
import com.ronbodnar.vehicletelemetry.kafka.KafkaProperties;
import com.ronbodnar.vehicletelemetry.service.VehicleTelemetryGenerator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VehicleTelemetryPublisher {

    private final KafkaProperties kafkaProperties;
    private final VehicleTelemetryGenerator telemetryGenerator;
    private final KafkaTemplate<String, VehicleTelemetryEvent> kafkaTemplate;

    public VehicleTelemetryPublisher(
            KafkaProperties kafkaProperties,
            VehicleTelemetryGenerator telemetryGenerator,
            KafkaTemplate<String, VehicleTelemetryEvent> kafkaTemplate
    ) {
        this.kafkaProperties = kafkaProperties;
        this.telemetryGenerator = telemetryGenerator;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void publishEvent() {
        VehicleTelemetryEvent event = telemetryGenerator.generateEntry();
        log.info("Publishing event {}", event);
        kafkaTemplate.send(kafkaProperties.topic(), event.vin(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to send event to Kafka", ex);
                    } else {
                        log.info("Sent message to partition {}", result.getRecordMetadata().partition());
                    }
                });
    }
}
