package com.paduankata.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paduankata.demo.request.UserRequest;
import com.paduankata.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootTest(classes = UserControllerTests.class)
@AutoConfigureMockMvc
@EnableWebMvc
@ActiveProfiles(profiles = "test")
class UserControllerTests {
  @Autowired
  private MockMvc mockMvc;

  @Mock
  private UserService userService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createUsersTests() throws Exception {
    String payload = new ObjectMapper()
    .writeValueAsString(
        UserRequest
          .builder()
          .email("abc@test.com")
          .phoneNumber("0888888678")
          .name("test")
          .build()
      );

    Mockito.doNothing().when(userService).createUsers(Mockito.any());
    mockMvc
      .perform(
        post("/users")
          .contentType("application/json")
          .accept("application/json")
          .content(payload)
      )
      .andExpect(status().isNotFound());
  }
}
