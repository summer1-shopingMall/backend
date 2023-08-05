package com.example.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
  private Long id;
  private Long productId;
  private Long userId;
  private int productCount;

  //product
  private String productName;
  private int productPrice;

  private LocalDateTime updated_at;
}
