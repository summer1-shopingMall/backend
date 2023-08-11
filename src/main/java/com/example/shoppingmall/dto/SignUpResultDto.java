package com.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDto {
  //회원가입 성공여부를 나타냄
  private boolean success;

  //결과 코드
  private int code;

  //결과 메세지
  private String msg;

}
