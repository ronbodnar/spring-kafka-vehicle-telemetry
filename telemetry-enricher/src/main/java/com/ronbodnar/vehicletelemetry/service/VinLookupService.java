package com.ronbodnar.vehicletelemetry.service;

import com.ronbodnar.vehicletelemetry.domain.VehicleInformation;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VinLookupService {

    // Normally the vin would be used to look at a data source.
    // We're just faking the data here.
    public VehicleInformation getVehicle(String vin) {
        String[] makes = new String[] {
                "Hyundai", "Genesis", "Kia"
        };
        String[] models = new String[] {
                "GV70", "GV80", "GV90", "Telluride", "Palisades", "Sonata", "Kona"
        };

        String randomMake = makes[(int) (Math.random() * makes.length)];
        String randomModel = models[(int) (Math.random() * models.length)];

        int randomYear = new Random().nextInt(2010, 2026);

        return new VehicleInformation(randomMake, randomModel, randomYear);
    }
}
