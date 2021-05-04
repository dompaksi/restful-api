package com.paduankata.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.paduankata.demo.entity.User;
import com.paduankata.demo.repository.UserRepository;
import com.paduankata.demo.request.UserRequest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(SpringExtension.class)
class UserServiceTests {
  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @Test
  void testEmailDuplicate() {
    UserRequest userRequest = UserRequest
      .builder()
      .name("test")
      .email("abc@test.com")
      .build();

    Mockito
      .when(userRepository.findByEmail(userRequest.getEmail()))
      .thenReturn(Optional.of(User.builder().email("abc@test.com").build()));

    ResponseStatusException exceptionResult = assertThrows(
      ResponseStatusException.class,
      () -> userService.createUsers(userRequest)
    );
    assertEquals(HttpStatus.NOT_ACCEPTABLE, exceptionResult.getStatus());
  }
}
