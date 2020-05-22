package com.stratio.financial.test.infrastructure.message.springkafka.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "kafka.producer.topic")
@NoArgsConstructor
@Getter
@Setter
public class SpringKafkaProducerTopicConfig {

  private String name;

  private int partitions;

  private short replicas;

}
