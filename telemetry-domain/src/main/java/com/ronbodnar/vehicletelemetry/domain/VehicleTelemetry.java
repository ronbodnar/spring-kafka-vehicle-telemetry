package com.ronbodnar.vehicletelemetry.domain;

import java.time.Instant;

public record VehicleTelemetry(Instant timestamp, Double latitude, Double longitude, Integer speed, Integer batteryPercentage) { }