package com.example.animalshelter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean emailExist(String email) {
    return userRepository.findByEmail(email) != null;
  }
}
