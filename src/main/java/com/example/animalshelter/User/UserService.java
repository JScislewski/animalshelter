package com.example.animalshelter.User;

import com.example.animalshelter.exception.PasswordsDoesNotMatchException;
import com.example.animalshelter.exception.UserAlreadyExistException;
import java.util.Arrays;
import javax.transaction.Transactional;
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

  @Transactional
  @Override
  public void registerNewUserAccount(UserDto userDto)
    throws UserAlreadyExistException, PasswordsDoesNotMatchException {
    if (emailExist(userDto.getEmail())) {
      throw new UserAlreadyExistException(
        "There is already an account with that email"
      );
    }
    if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
      throw new PasswordsDoesNotMatchException("Passwords does not match");
    }
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setRole(Role.USER);
    userRepository.save(user);
  }
}
