package com.ronbodnar.vehicletelemetry.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        String topic,
        Integer partitions,
        Integer replicas
) {}
