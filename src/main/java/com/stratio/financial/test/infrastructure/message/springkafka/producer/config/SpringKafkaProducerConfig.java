package com.stratio.financial.test.infrastructure.message.springkafka.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stratio.financial.stratio.kafka.producer.StratioKafkaIsolatedEventProducer;
import com.stratio.financial.test.application.producer.EventProducer;
import com.stratio.financial.test.infrastructure.message.springkafka.producer.SpringKafkaEventProducer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SpringKafkaProducerConfig {

  private final ObjectMapper objectMapper;

  private final StratioKafkaIsolatedEventProducer stratioKafkaEventProducer;


  @Bean
  public EventProducer<String, Object> stratioKafkaEventProducerAdapter() {
    return new SpringKafkaEventProducer<>(stratioKafkaEventProducer, objectMapper);
  }
}
