package com.stratio.financial.test.infrastructure.message.springkafka.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stratio.financial.stratio.kafka.producer.StratioKafkaEventProducer;
import com.stratio.financial.test.application.producer.EventProducer;
import com.stratio.financial.test.infrastructure.message.springkafka.producer.SpringKafkaEventProducer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SpringKafkaProducerConfig {

  private final ObjectMapper objectMapper;

  private final StratioKafkaEventProducer stratioKafkaEventProducer;


  @Bean
  public EventProducer<String, Object> stratioKafkaEventProducerAdapter() {
    return new SpringKafkaEventProducer<String, Object>(stratioKafkaEventProducer, objectMapper);
  }
}
