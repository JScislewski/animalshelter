package com.example.animalshelter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends Exception {

  public UserAlreadyExistException(String errorMessage) {
    super(errorMessage);
  }
}
