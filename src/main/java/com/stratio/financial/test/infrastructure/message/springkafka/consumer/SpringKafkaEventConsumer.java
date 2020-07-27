package com.stratio.financial.test.infrastructure.message.springkafka.consumer;

import com.stratio.financial.stratio.kafka.consumer.annotation.StratioEventHubConsumer;
import com.stratio.financial.stratio.kafka.consumer.annotation.StratioKafkaConsumer;
import com.stratio.financial.stratio.kafka.producer.StratioKafkaEventProducer;
import com.stratio.financial.test.infrastructure.eventhub.SimpleMessage;
import com.stratio.financial.test.infrastructure.message.springkafka.consumer.model.SpringKafkaEventToConsume;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class SpringKafkaEventConsumer {

  private final StratioKafkaEventProducer stratioKafkaEventProducerAdapter;

  @StratioKafkaConsumer(topic = "eventhubtopic")
  public void consumeEventHubTopic(SimpleMessage consumerMessage) {
    log.info("Consuming From Event Hub Azure {}", consumerMessage.toString());
    log.info("Producing to Event Hub Azure {}",  consumerMessage.toString());
    stratioKafkaEventProducerAdapter.send("producerEventHub", consumerMessage.toString(), "noaction");
  }

  @StratioKafkaConsumer(topic = "kafkatopic")
  public void consumeKafkaTopic(SpringKafkaEventToConsume consumerMessage) {
    log.info("Consuming From Kafka {}", consumerMessage.toString());
  }

}