package com.stratio.financial.test.infrastructure.eventhub;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaProducer kafkaProducer;

    @PostMapping("send")
    public void sendData(@RequestBody SimpleMessage message) {
        this.kafkaProducer.send(message);
    }
}
