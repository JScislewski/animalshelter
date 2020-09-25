package com.example.animalshelter.exception;

public class UserAlreadyExistException extends Exception {

  public UserAlreadyExistException(String errorMessage) {
    super(errorMessage);
  }
}
