package com.stratio.financial.test.infrastructure.eventhub;

import org.springframework.kafka.support.serializer.JsonSerializer;

public class ProducerMessageSerializer extends JsonSerializer<SimpleMessage> {
}
