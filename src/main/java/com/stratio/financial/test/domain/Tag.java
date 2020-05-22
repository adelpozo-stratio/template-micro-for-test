package com.stratio.financial.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tag {

  @Id
  private Long id;

  private String name;

  @ManyToOne
  private Pet pet;

}
