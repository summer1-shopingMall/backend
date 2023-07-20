package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
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
  private Long userId;

  @NotNull
  private int productCount;

  private LocalDateTime updated_at;
}
