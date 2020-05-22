package com.stratio.financial.test.infrastructure.message.springkafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stratio.financial.stratio.kafka.producer.StratioKafkaIsolatedEventProducer;
import com.stratio.financial.test.application.producer.EventProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpringKafkaEventProducer<K, T> implements EventProducer<K, T> {

  private final StratioKafkaIsolatedEventProducer stratioKafkaEventProducer;

  private final ObjectMapper objectMapper;

  @Override
  public void send(K eventKey, T eventData, String action) {
    try {
      String eventDataStr = objectMapper.writeValueAsString(eventData);
      stratioKafkaEventProducer.send(eventKey.toString(), eventDataStr, action);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }


  }

}
