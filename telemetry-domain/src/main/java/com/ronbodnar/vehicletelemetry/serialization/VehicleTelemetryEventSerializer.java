package com.ronbodnar.vehicletelemetry.serialization;

import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.apache.kafka.common.serialization.Serializer;

public class VehicleTelemetryEventSerializer implements Serializer<VehicleTelemetryEvent> {

    public VehicleTelemetryEventSerializer() {}

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public byte[] serialize(String topic, VehicleTelemetryEvent data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
