package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String userId;

  @NotNull
  private String address1;

  @NotNull
  private String address2;

  private String address3;

  private String receiverName;

  private String receiverPhone;

  private LocalDateTime orderDate;
}
