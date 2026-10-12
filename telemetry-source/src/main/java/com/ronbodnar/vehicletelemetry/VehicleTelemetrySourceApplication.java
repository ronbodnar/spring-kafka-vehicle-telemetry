package com.ronbodnar.vehicletelemetry;

import com.ronbodnar.vehicletelemetry.kafka.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties(KafkaProperties.class)
@SpringBootApplication
public class VehicleTelemetrySourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleTelemetrySourceApplication.class, args);
    }
}
