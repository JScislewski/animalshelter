package com.example.animalshelter.system;

import com.example.animalshelter.User.Role;
import com.example.animalshelter.User.User;
import com.example.animalshelter.User.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetails implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("No user with username: " + username);
    }
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(),
      user.getPassword(),
      enabled,
      accountNonExpired,
      credentialsNonExpired,
      accountNonLocked,
      getGrantedAuthorities(user.getRole())
    );
  }

  private static List<GrantedAuthority> getGrantedAuthorities(Role role) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(role.toString()));
    return authorities;
  }
}
