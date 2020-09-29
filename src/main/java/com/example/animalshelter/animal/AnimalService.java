package com.example.animalshelter.animal;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AnimalService implements IAnimalService {
  private AnimalRepository animalRepository;

  public AnimalService(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Transactional
  @Override
  public Animal addNewAnimal(AnimalDto animalDto) {
    Animal animal = new Animal(
      animalDto.getName(),
      animalDto.getAge(),
      animalDto.getGender(),
      animalDto.getSpecies(),
      animalDto.getBreed(),
      Status.Available
    );
    return animalRepository.save(animal);
  }
}
