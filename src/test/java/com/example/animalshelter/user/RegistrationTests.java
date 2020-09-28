package com.example.animalshelter.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.animalshelter.User.UserDto;
import com.example.animalshelter.User.UserRepository;
import com.example.animalshelter.User.UserService;
import com.example.animalshelter.exception.PasswordsDoesNotMatchException;
import com.example.animalshelter.exception.UserAlreadyExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationTests {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Test
  void registerNewUserAccount_validUser_success()
    throws PasswordsDoesNotMatchException, UserAlreadyExistException {
    int userCount = userRepository.findAll().size();
    UserDto userDto = new UserDto(
      "user1",
      "user1@gmail.com",
      "password",
      "password"
    );
    userService.registerNewUserAccount(userDto);
    assertThat(userRepository.findAll().size()).isEqualTo(userCount + 1);
    assertThat(userRepository.findByUsername(userDto.getUsername()))
      .isNotNull();
  }

  @Test
  void registerNewUserAccount_duplicateEmail_exception()
    throws PasswordsDoesNotMatchException, UserAlreadyExistException {
    int userCount = userRepository.findAll().size();
    UserDto firstUser = new UserDto(
      "user2",
      "user2@gmail.com",
      "password",
      "password"
    );
    UserDto secondUser = new UserDto(
      "user3",
      "user2@gmail.com",
      "password",
      "password"
    );
    userService.registerNewUserAccount(firstUser);
    Exception exception = assertThrows(
      UserAlreadyExistException.class,
      () -> {
        userService.registerNewUserAccount(secondUser);
      }
    );
    assertThat(exception.getMessage())
      .isEqualTo("There is already an account with that email");
  }
}
