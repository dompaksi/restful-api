package com.paduankata.demo.service;

import com.paduankata.demo.entity.User;
import com.paduankata.demo.repository.UserRepository;
import com.paduankata.demo.response.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<UserResponse> getUsers() {
    List<User> users = userRepository.findAll();
    return users
      .stream()
      .map(
        thisUser ->
          UserResponse
            .builder()
            .id(thisUser.getId())
            .name(thisUser.getName())
            .phoneNumber(thisUser.getPhoneNumber())
            .dateOfBirth(thisUser.getDateOfBirth())
            .email(thisUser.getEmail())
            .build()
      )
      .collect(Collectors.toList());
  }
}
