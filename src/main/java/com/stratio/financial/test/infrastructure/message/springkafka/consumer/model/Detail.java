package com.stratio.financial.test.infrastructure.message.springkafka.consumer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Detail {
    private int index;
    private String description;
}
