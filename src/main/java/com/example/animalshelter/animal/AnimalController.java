package com.example.animalshelter.animal;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnimalController {
  private final AnimalRepository animalRepository;

  public AnimalController(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @GetMapping("/animal")
  public ResponseEntity<List<Animal>> getAllAnimals() {
    return new ResponseEntity<>(animalRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/animal")
  public ResponseEntity<Animal> getAnimal(@RequestParam(name = "id") long id) {
    Optional<Animal> animal = animalRepository.findById(id);
    return animal
      .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
