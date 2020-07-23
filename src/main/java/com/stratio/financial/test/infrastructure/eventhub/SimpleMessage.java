package com.stratio.financial.test.infrastructure.eventhub;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SimpleMessage implements Serializable {
    private String body;
}
