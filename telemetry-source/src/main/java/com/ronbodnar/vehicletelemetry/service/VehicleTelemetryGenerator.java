package com.ronbodnar.vehicletelemetry.service;

import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetry;
import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VehicleTelemetryGenerator {

    public VehicleTelemetryEvent generateEntry() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        String vin = "VIN" + random.nextInt(100000, 999999);

        VehicleTelemetry telemetry = new VehicleTelemetry(
                Instant.now(),
                random.nextDouble(),
                random.nextDouble(),
                random.nextInt(0, 120), random.nextInt(0, 100)
        );

        return new VehicleTelemetryEvent(vin, telemetry);
    }
}
