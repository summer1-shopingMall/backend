package com.example.shoppingmall.dto;

import com.example.shoppingmall.entity.Cart;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartResponseDto {
  private Long id;
  private Long productId;
  private String userId;
  private int productPrice;
  private int productCount;
  private String productName;
  private LocalDateTime updated_at;

  public CartResponseDto() {
  }

  public CartResponseDto(Cart cart) {
    this.id = cart.getId();
    this.productId = cart.getProductId();
    this.userId = cart.getUserId();
    this.productPrice = cart.getProductPrice();
    this.productCount = cart.getProductCount();
    this.productName = cart.getProductName();
    this.updated_at = cart.getUpdated_at();
  }
}