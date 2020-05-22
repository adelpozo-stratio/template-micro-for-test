package com.stratio.financial.test.infrastructure.message.springkafka.producer.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SpringKafkaEventToProduce implements Serializable {

  private Long id;

  //Model internal event to produce...

}
