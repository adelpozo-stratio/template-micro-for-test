package com.stratio.financial.test.infrastructure.eventhub;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void receive(SimpleMessage consumerMessage) {
        log.info("Received message from kafka queue: {}", consumerMessage.getBody());
    }
}
