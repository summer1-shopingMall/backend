package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.UserDto;
import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.repository.UserRepository;
import com.example.shoppingmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDto userByUserId(String userId) {
    User user = userRepository.getByUserId(userId);
    UserDto userDto = new UserDto(user);
    return userDto;
  }
}
