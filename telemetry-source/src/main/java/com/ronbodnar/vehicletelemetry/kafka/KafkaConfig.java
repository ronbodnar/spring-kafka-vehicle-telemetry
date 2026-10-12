package com.ronbodnar.vehicletelemetry.kafka;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public NewTopic vehicleTelemetryTopic() {
        return TopicBuilder.name(kafkaProperties.topic())
                .partitions(kafkaProperties.partitions())
                .replicas(kafkaProperties.replicas())
                .build();
    }
}
