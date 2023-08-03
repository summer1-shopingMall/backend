package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.SignInResultDto;
import com.example.shoppingmall.dto.SignUpResultDto;

public interface SignService {

  SignUpResultDto UserSignUp(String userId, String password, String userName, String email, String phone);

  SignInResultDto signIn(String id, String password) throws RuntimeException;

}
