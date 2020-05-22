package com.stratio.financial.test.infrastructure.message.springkafka.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stratio.financial.stratio.kafka.consumer.annotation.StratioKafkaConsumer;
import com.stratio.financial.test.infrastructure.message.springkafka.ConsumerTestCustomException;
import com.stratio.financial.test.infrastructure.message.springkafka.consumer.model.SpringKafkaEventToConsume;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringKafkaEventConsumer {

  private Map<String, List<Object>> mapOfElements = new HashMap<>();

  private Integer countOfelemts = 1;

  @StratioKafkaConsumer(topic = "test")
  public void consumeExternalEventOK(SpringKafkaEventToConsume eventToConsume) {
    log.info("Count {}. Consuming event {}", countOfelemts, eventToConsume.toString());
    consumeBykey(eventToConsume);
    log.info("Event consumed : " + countOfelemts++);
    log.info("Consuming event {}", eventToConsume.toString());
    consumeBykey(eventToConsume);
    log.info("Event consumed");
  }

  @StratioKafkaConsumer(topic = "testFailure")
  public void consumeExternalEventFailure(SpringKafkaEventToConsume eventToConsume) throws ConsumerTestCustomException {
    if (countOfelemts > 4) {
      log.info("Count {}. Consuming event {}", countOfelemts, eventToConsume.toString());
      consumeBykey(eventToConsume);
      log.info("Event consumed : " + ++countOfelemts);
    } else {
      throw new ConsumerTestCustomException(
          "ERROR FORZADO PARA EVENTO " + countOfelemts + " --> " + eventToConsume.toString());
    }
  }

  @StratioKafkaConsumer(topic = "sleep")
  public void consumeExternalEventSleep(SpringKafkaEventToConsume eventToConsume) throws InterruptedException {
    Thread.sleep(120000);
  }

  @StratioKafkaConsumer(topic = "throw")
  public void consumeExternalEventError(SpringKafkaEventToConsume eventToConsume) throws InterruptedException {
    throw new RuntimeException("ERROR FORZADO");
  }

  private void consumeBykey(final SpringKafkaEventToConsume eventToConsume) {
    registerValueToMap(eventToConsume, eventToConsume.getKey());
  }

  private void releasePackageOfSomethingByKey(final String key) {
    Map<String, List<Object>> result = mapOfElements.entrySet().stream()
        .filter(map -> map.getKey().equalsIgnoreCase(key))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    mapOfElements.remove(key);

    printValues(result);
  }

  public void registerValueToMap(SpringKafkaEventToConsume obj, String key) {
    if (mapOfElements.containsKey(key)) {
      mapOfElements.get(key).add(obj);
    } else {
      List appendList = new ArrayList<Object>();
      appendList.add(obj);
      mapOfElements.put(key, appendList);
    }

    if (obj.isLast()) {
      releasePackageOfSomethingByKey(key);
    }
  }

  public void printValues(Map<String, List<Object>> map) {
    map.forEach((key, value) -> System.out.println(key + ":" + value));
  }


}