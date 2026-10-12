package com.ronbodnar.vehicletelemetry.service;

import com.ronbodnar.vehicletelemetry.domain.EnrichedVehicleTelemetry;
import com.ronbodnar.vehicletelemetry.domain.VehicleInformation;
import com.ronbodnar.vehicletelemetry.domain.VehicleTelemetryEvent;
import org.springframework.stereotype.Service;

@Service
public class TelemetryEnrichmentService {

    private final VinLookupService vinLookupService;

    public TelemetryEnrichmentService(VinLookupService vinLookupService) {
        this.vinLookupService = vinLookupService;
    }

    public EnrichedVehicleTelemetry enrich(VehicleTelemetryEvent entry) {
        VehicleInformation vehicleInformation = vinLookupService.getVehicle(entry.vin());

        return new EnrichedVehicleTelemetry(
                entry.vin(),
                entry.vehicleTelemetry(),
                vehicleInformation
        );
    }
}
