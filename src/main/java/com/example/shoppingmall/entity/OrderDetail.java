package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orderDetail")
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Long orderId;

  @NotNull
  private Long productId;

  private int price;

  @NotNull
  private int count;

  @NotNull
  private String status;

  private boolean refundCheck;

  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
