package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.SignInResultDto;
import com.example.shoppingmall.dto.SignUpResultDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface SignService {

  SignUpResultDto UserSignUp(String userId, String password, String userName, String email, String phone);

  SignUpResultDto SellerSignUp( String sellerID,  String sellerPw,
                                String sellerName,  String phoneNumber,
                                String companyNumber, String companyName,  String address1,
                                String address2,  String address3,
                                String bank,  String receiveName,
                                String bankAddress);

  SignInResultDto signIn(String id, String password) throws RuntimeException;

  SignInResultDto SellerSignIn(String id, String password) throws RuntimeException;


}
