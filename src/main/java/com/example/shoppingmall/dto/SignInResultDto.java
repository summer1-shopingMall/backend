package com.example.shoppingmall.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignInResultDto extends SignUpResultDto{

  private String token;
  private String userId;

  @Builder
  public SignInResultDto(boolean success, int code, String msg, String token, String userId) {
    super(success, code, msg);
    this.token = token;
    this.userId = userId;
  }
}