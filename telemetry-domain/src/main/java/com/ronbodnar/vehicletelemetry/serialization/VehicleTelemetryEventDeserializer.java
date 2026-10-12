package com.ronbodnar.vehicletelemetry.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class VehicleTelemetryEventDeserializer implements Deserializer<VehicleTelemetryEvent> {

    public VehicleTelemetryEventDeserializer() {}

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public VehicleTelemetryEvent deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(new String(data), VehicleTelemetryEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
