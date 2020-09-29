package com.example.animalshelter.animal;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnimalController {
  private final AnimalRepository animalRepository;
  private final AnimalService animalService;

  public AnimalController(
    AnimalRepository animalRepository,
    AnimalService animalService
  ) {
    this.animalRepository = animalRepository;
    this.animalService = animalService;
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

  @PostMapping("/animal")
  public ResponseEntity<Animal> addNewAnimal(
    @RequestBody @Valid AnimalDto animalDto
  ) {
    Animal animal = animalService.addNewAnimal(animalDto);
    return new ResponseEntity<>(animal, HttpStatus.OK);
  }

  @DeleteMapping("/animal")
  public ResponseEntity<Void> deleteAnimal(@RequestParam(name = "id") long id) {
    Optional<Animal> animal = animalRepository.findById(id);
    if (animal.isPresent()) {
      animalRepository.delete(animal.get());
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping
  public ResponseEntity<Void> updateAnimal(
    @RequestParam(name = "id") long id,
    AnimalDto animalDto
  ) {
    if (animalService.updateAnimal(id, animalDto).isPresent()) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
