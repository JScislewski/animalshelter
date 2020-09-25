package com.example.animalshelter.User;

import com.example.animalshelter.User.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = new ArrayList<>();
    User user1 = new User("Jan", "password");
    users.add(user1);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
