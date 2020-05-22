package com.stratio.financial.test.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {

  @Id
  private Long id;

  private Long petId;

  private Integer quantity;

  private OffsetDateTime shipDate;

  @Enumerated
  private StatusEnum status;

  private Boolean complete = false;


  public enum StatusEnum {

    PLACED("placed"),

    APPROVED("approved"),

    DELIVERED("delivered");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }


}
