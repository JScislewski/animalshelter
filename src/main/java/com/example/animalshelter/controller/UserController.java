package com.example.animalshelter.controller;

import com.example.animalshelter.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
public class UserController {
  @GetMapping("/admin/candidates")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = new ArrayList<>();
    User user1 = new User("Jan", "password");
    users.add(user1);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
