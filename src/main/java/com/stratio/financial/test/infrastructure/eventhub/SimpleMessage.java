package com.stratio.financial.test.infrastructure.eventhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleMessage {
    private String body;
}
