package com.ronbodnar.vehicletelemetry.domain;

public record EnrichedVehicleTelemetry(String vin, VehicleTelemetry telemetry, VehicleInformation vehicleInformation) { }
