package com.example.animalshelter.animal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 32, nullable = false)
  private String name;

  private int age;

  @Column(length = 32, nullable = false)
  @Enumerated
  private Gender gender;

  @Column(length = 32, nullable = false)
  @Enumerated
  private Species species;

  @Column(length = 32, nullable = false)
  private String breed;

  @Column(length = 32, nullable = false)
  @Enumerated
  private Status status;

  public Animal(
    String name,
    int age,
    Gender gender,
    Species species,
    String breed,
    Status status
  ) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.species = species;
    this.breed = breed;
    this.status = status;
  }
}
