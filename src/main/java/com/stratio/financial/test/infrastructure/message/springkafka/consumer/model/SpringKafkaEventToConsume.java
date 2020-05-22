package com.stratio.financial.test.infrastructure.message.springkafka.consumer.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SpringKafkaEventToConsume implements Serializable {

  private Long id;

  private String key;

  private String value;

  private boolean last;

  private Detail detail;

  //Model the external event to consume...

}
