package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.UserResponseDto;
import com.example.shoppingmall.entity.User;

import java.util.Optional;

public interface UserService{
  UserResponseDto userByUserId(String userId);
  Optional<User> findByEmail(String email);
}
