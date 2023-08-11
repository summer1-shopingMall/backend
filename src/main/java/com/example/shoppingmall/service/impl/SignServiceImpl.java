package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.config.security.JwtTokenProvider;
import com.example.shoppingmall.dto.CommonResponse;
import com.example.shoppingmall.dto.SignInResultDto;
import com.example.shoppingmall.dto.SignUpResultDto;
import com.example.shoppingmall.entity.Seller;
import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.repository.SellerRepository;
import com.example.shoppingmall.repository.UserRepository;
import com.example.shoppingmall.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService {

  public UserRepository userRepository;
  public JwtTokenProvider jwtTokenProvider;
  public PasswordEncoder passwordEncoder;

  public SellerRepository sellerRepository;

  @Autowired
  public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder,  SellerRepository sellerRepository) {
    this.userRepository = userRepository;
    this.jwtTokenProvider = jwtTokenProvider;
    this.passwordEncoder = passwordEncoder;
    this.sellerRepository = sellerRepository;
  }

  @Override
  public SignUpResultDto UserSignUp(String userId, String password, String userName, String email, String phone) {
    System.out.println("[signUp] 회원가입");
    User user;
    //password를 암호화해서 저장, 판매자가 아닌 유저회원가입이기때문에 role을 user로 고정해놓은 것.
    user = User.builder().userId(userId).userName(userName).email(email).phone(phone).type("general")
          .password(passwordEncoder.encode(password)).roles(Collections.singletonList("ROLE_USER")).build();
    User savedUser = userRepository.save(user);
    SignUpResultDto signUpResultDto = new SignUpResultDto();
    if(!savedUser.getUsername().isEmpty()) {
      setSuccessResult(signUpResultDto);
    } else {
      setFailResult(signUpResultDto);
    }
    return signUpResultDto;
  }

  @Override
  public SignUpResultDto SellerSignUp(String sellerID,  String sellerPw,
                                      String sellerName,  String phoneNumber,
                                      String companyNumber,  String boss,
                                      String companyName,  String address1,
                                      String address2,  String address3,
                                      String bank,  String receiveName,
                                      String bankAddress) {
    System.out.println("[seller] 회원가입");
    Seller seller;
    seller = Seller.builder().sellerID(sellerID).sellerName(sellerName).phoneNumber(phoneNumber).companyNumber(companyNumber)
            .boss(boss).companyName(companyName).address1(address1).address2(address2).address3(address3).bank(bank).receiveName(receiveName).bankAddress(bankAddress)
            .sellerPw(passwordEncoder.encode(sellerPw)).roles(Collections.singletonList("ROLE_USER")).build();
    Seller sellerSaved = sellerRepository.save(seller);
    SignUpResultDto signUpResultDto = new SignUpResultDto();
    if(!sellerSaved.getUsername().isEmpty()) {
      setSuccessResult(signUpResultDto);
    } else {
      setFailResult(signUpResultDto);
    }
    return signUpResultDto;
  }


  @Override
  public SignInResultDto signIn(String id, String password) throws RuntimeException {
    User user = userRepository.getByUserId(id);
    if(!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException();
    }

    SignInResultDto signInResultDto = SignInResultDto.builder().token(jwtTokenProvider.createToken(String.valueOf(user.getUserId()), user.getRoles())).userId(id).build();
    setSuccessResult(signInResultDto);

    return signInResultDto;
  }

  @Override
  public SignInResultDto SellerSignIn(String id, String password) throws RuntimeException {
    Seller seller = sellerRepository.getBySellerID(id);
    if(!passwordEncoder.matches(password, seller.getSellerPw())) {
      throw new RuntimeException();
    }

    SignInResultDto signInResultDto = SignInResultDto.builder().token(jwtTokenProvider.createToken(String.valueOf(seller.getSellerID()), seller.getRoles())).build();
    setSuccessResult(signInResultDto);

    return signInResultDto;
  }

  private void setSuccessResult(SignUpResultDto result) {
    result.setSuccess(true);
    result.setCode(CommonResponse.SUCCESS.getCode());
    result.setMsg(CommonResponse.SUCCESS.getMsg());
  }
  private void setFailResult(SignUpResultDto result) {
    result.setSuccess(false);
    result.setCode(CommonResponse.FAIL.getCode());
    result.setMsg(CommonResponse.FAIL.getMsg());
  }
}