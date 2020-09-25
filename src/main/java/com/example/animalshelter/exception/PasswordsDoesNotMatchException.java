package com.example.animalshelter.exception;

public class PasswordsDoesNotMatchException extends Exception {

  public PasswordsDoesNotMatchException(String errorMessage) {
    super(errorMessage);
  }
}
