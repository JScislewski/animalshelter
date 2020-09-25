package com.example.animalshelter.User;

import com.sun.istack.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDto {
  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  @Email
  private String email;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  private String confirmPassword;
}
