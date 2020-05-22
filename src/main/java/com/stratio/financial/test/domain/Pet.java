package com.stratio.financial.test.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pet {

  @Id
  private Long id;

  @ManyToOne
  private Category category;

  private String name;

  @ElementCollection
  @Column(name = "photos")
  private List<String> photoUrls;

  @OneToMany(mappedBy = "pet", targetEntity = Tag.class)
  private List<Tag> tags;

  @Enumerated(EnumType.STRING)
  private StatusEnum status;

  public enum StatusEnum {

    AVAILABLE("available"),

    PENDING("pending"),

    SOLD("sold");

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
