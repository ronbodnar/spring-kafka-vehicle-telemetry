package com.ronbodnar.vehicletelemetry.domain;

public record VehicleTelemetryEvent(String vin, VehicleTelemetry vehicleTelemetry) {
}
