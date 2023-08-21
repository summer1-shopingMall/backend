package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String category;

  @NotNull
  private String sellerId;

  @NotNull
  private String productName;

  @NotNull
  private int price;

  private int stock;
  //잔여량
  @NotNull
  private int status;

  @NotNull
  private int cellCount;

  private String spec;

  private String content;

  private String url;

  private int views;

  private String createdAt;
  //상품 등록 날자
  private String updatedAt;
  //상품 수정 날자

}
