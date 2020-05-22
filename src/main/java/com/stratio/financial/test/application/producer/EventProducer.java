package com.stratio.financial.test.application.producer;

public interface EventProducer<K, T> {
    void send(K eventKey, T eventData, String action);
}