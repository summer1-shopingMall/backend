package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.UserDto;

public interface UserService {
  UserDto userByUserId(String userId);
}
