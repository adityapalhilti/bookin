package com.bookin.bookin.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig{

    @Bean
    public NewTopic bookish() {
        return TopicBuilder.name("topic").partitions(10).build();

    }
}