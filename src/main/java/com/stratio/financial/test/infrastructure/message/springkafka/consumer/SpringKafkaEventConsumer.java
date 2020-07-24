package com.stratio.financial.test.infrastructure.message.springkafka.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stratio.financial.stratio.kafka.consumer.annotation.StratioKafkaConsumer;
import com.stratio.financial.stratio.kafka.producer.StratioKafkaEventProducer;
import com.stratio.financial.test.infrastructure.eventhub.SimpleMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class SpringKafkaEventConsumer {

  private final StratioKafkaEventProducer stratioKafkaEventProducerAdapter;

  private Map<String, List<Object>> mapOfElements = new HashMap<>();

  private Integer countOfelemts = 1;

  @StratioKafkaConsumer(topic = "eventhubaad")
  public void consumeEventHubTopic(SimpleMessage consumerMessage) {
    log.info("Consuming From Event Hub Azure {}", consumerMessage.toString());
    log.info("Producing to Event Hub Azure {}",  consumerMessage.toString());
    stratioKafkaEventProducerAdapter.send("producerEventHub", consumerMessage.toString(), "noaction");
  }


}