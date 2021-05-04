package com.paduankata.demo.controller;

import com.paduankata.demo.request.UserRequest;
import com.paduankata.demo.response.UserResponse;
import com.paduankata.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "User controller")
@Validated
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/users")
  @ApiOperation(value = "Get user information")
  @ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "OK", response = UserResponse.class),
      @ApiResponse(code = 400, message = "Bad request due to incorrect payload")
    }
  )
  public List<UserResponse> getUsers() {
    return userService.getUsers();
  }

  @PostMapping("/users")
  @ApiOperation(value = "Create a new users")
  @ApiResponses(
    value = {
      @ApiResponse(code = 201, message = "CREATED", response = void.class),
      @ApiResponse(code = 400, message = "Bad request due to incorrect payload")
    }
  )
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createUsers(@RequestBody @Valid UserRequest userRequest) {
    userService.createUsers(userRequest);
  }
}
