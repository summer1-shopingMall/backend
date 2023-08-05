package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
  //유저별 장바구니 리스트
  List<Cart> findByUserId(Long userId);

}
