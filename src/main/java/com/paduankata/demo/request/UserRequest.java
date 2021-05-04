package com.paduankata.demo.request;

import com.paduankata.demo.constant.RegexConstants;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  @NotEmpty
  private String name;

  @NotEmpty
  private LocalDate dateOfBirth;

  @NotEmpty
  private String phoneNumber;

  private String tier;

  @Pattern(regexp = RegexConstants.EMAIL_REGEX)
  private String email;
}
