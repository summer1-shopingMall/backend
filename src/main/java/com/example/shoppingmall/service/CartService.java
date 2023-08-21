package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.CartDto;
import com.example.shoppingmall.dto.CartResponseDto;

import java.util.List;

public interface CartService {
  //장바구니 추가
  CartResponseDto insertCart(CartDto cartDto);

  //장바구니 한개 삭제
  void delectCart(Long id) throws Exception;

  //장바구니 여러개 한번에 삭제


  //장바구니 한개 상세보기
  CartResponseDto selectCart(Long id);

  //유저별 장바구니 리스트
  List<CartResponseDto> listOrderByUserId(String userId);

}