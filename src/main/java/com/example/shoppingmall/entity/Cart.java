package com.example.shoppingmall.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cart")
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Long productId;

  @NotNull
  private String userId;

  @NotNull
  private int productPrice;

  @NotNull
  private int productCount;

  //product
  @NotNull
  private String productName;



  private LocalDateTime updated_at;
}
