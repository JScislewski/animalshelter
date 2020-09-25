package com.example.animalshelter.User;

import com.example.animalshelter.exception.UserAlreadyExistException;

public interface IUserService {
  boolean emailExist(String email);
  void registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;
}
