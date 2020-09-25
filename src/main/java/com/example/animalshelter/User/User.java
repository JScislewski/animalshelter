package com.example.animalshelter.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(length = 32, nullable = false)
  private String username;

  @Column(nullable = false)
  @Email
  private String email;

  @Column(length = 64, nullable = false)
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
