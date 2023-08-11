package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.SignInResultDto;
import com.example.shoppingmall.dto.SignUpResultDto;
import com.example.shoppingmall.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-api")
public class SignController {

  private final SignService signService;

  @Autowired
  public SignController(SignService signService) {
    this.signService = signService;
  }

  @PostMapping("/user-sign-in")
  public SignInResultDto UserSignIn(@RequestParam String id, @RequestParam String password) throws RuntimeException {
    SignInResultDto signInResultDto = signService.signIn(id, password);
    if(signInResultDto.getCode() == 0) {
      System.out.println("[SignIn] 정상적으로 로그인되었습니다. "+ signInResultDto.getToken());
    }
    return signInResultDto;
  }
  @PostMapping("/user-sign-up")
  public SignUpResultDto UserSignUp(@RequestParam String id, @RequestParam String password,@RequestParam String name,  @RequestParam String email,@RequestParam String phone) throws RuntimeException {
    SignUpResultDto signUpResultDto = signService.UserSignUp(id, password, name,email,phone);
    return signUpResultDto;
  }

  @GetMapping("/exception")
  public void exception() throws RuntimeException {
    throw new RuntimeException("접근이 금지되었습니다.");
  }

  @PostMapping("/seller-sign-in")
  public SignInResultDto SellerSignIn(@RequestParam String id, @RequestParam String password) throws RuntimeException
  {
    SignInResultDto signInResultDto = signService.SellerSignIn(id, password);
    if(signInResultDto.getCode() == 0) {
      System.out.println("[SignIn] 정상적으로 로그인되었습니다. "+ signInResultDto.getToken());
    }
    return signInResultDto;
  }

  @PostMapping("/seller-sign-up")
  public SignUpResultDto SellerSignUp(@RequestParam String sellerID, @RequestParam String sellerPw,
                                      @RequestParam String sellerName,  @RequestParam String phoneNumber,
                                      @RequestParam String companyNumber, @RequestParam String boss,
                                      @RequestParam String companyName,@RequestParam String address1,
                                      @RequestParam String address2,@RequestParam String address3,
                                      @RequestParam String bank,@RequestParam String receiveName,
                                      @RequestParam String bankAddress) throws RuntimeException
  {
    SignUpResultDto signUpResultDto = signService.SellerSignUp(sellerID, sellerPw, sellerName,phoneNumber,companyNumber,
            boss,companyName,address1,address2,address3,bank,receiveName,bankAddress);
    return signUpResultDto;
  }

}
