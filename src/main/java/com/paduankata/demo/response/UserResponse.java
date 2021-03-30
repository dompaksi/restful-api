package com.paduankata.demo.response;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
  private long id;
  private String name;
  private LocalDate dateOfBirth;
  private String referralCode;
  private String phoneNumber;
  private String email;
}
