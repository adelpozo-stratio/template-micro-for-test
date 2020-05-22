package com.stratio.financial.test.infrastructure.message.springkafka;

public class ConsumerTestCustomException extends Exception{

  public ConsumerTestCustomException(String message) {
    super(message);
  }
}
