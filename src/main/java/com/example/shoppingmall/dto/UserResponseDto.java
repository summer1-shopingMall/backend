package com.example.shoppingmall.dto;

import com.example.shoppingmall.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
  private Long id;
  private String userId;
  private String userName;
  private String password;
  private String email;
  private String type;
  //네이버인지 구글인지 카카오인지 회원가입 타입 결정

  private long address1;

  private long address2;

  private long address3;

  private String phone;

  public UserResponseDto(User user) {
    id = user.getId();
    userId = user.getUserId();
    userName = user.getUsername();
    password = user.getPassword();
    email = user.getEmail();
    type = user.getType();
    address1 = user.getAddress1();
    address2 = user.getAddress2();
    address3 = user.getAddress3();
    phone = user.getPhone();
  }
}
