package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.UserResponseDto;
import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.repository.UserRepository;
import com.example.shoppingmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserResponseDto userByUserId(String userId) {
    User user = userRepository.getByUserId(userId);
    UserResponseDto userResponseDto = new UserResponseDto(user);
    return userResponseDto;
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
