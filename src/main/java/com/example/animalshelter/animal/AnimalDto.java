package com.example.animalshelter.animal;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalDto {
  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private int age;

  @NotNull
  @NotEmpty
  private Gender gender;

  @NotNull
  @NotEmpty
  private Species species;

  @NotNull
  @NotEmpty
  private String breed;
}
