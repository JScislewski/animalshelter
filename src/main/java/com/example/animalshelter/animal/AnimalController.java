package com.example.animalshelter.animal;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
