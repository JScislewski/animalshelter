package com.example.animalshelter.animal;

import java.util.Optional;

public interface IAnimalService {
  Animal addNewAnimal(AnimalDto animalDto);
  Optional<Animal> updateAnimal(long id, AnimalDto animalDto);
}
