package com.example.animalshelter.User;

import com.example.animalshelter.exception.UserAlreadyExistException;
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

  @Override
  public void registerNewUserAccount(UserDto userDto)
    throws UserAlreadyExistException {
    if (emailExist(userDto.getEmail())) {
      throw new UserAlreadyExistException(
        "There is already an account with that email"
      );
    }
  }
}
