package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "order")
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "seller_id", nullable = false)
  private Seller seller;
  @NotNull
  private String productName;
  @NotNull
  private String userId;
  @NotNull
  private String userName;
  @NotNull
  private String address1;
  @NotNull
  private String address2;

  private String address3;

  private String receiverName;

  private String receiverPhone;

  private LocalDateTime orderDate;

  private String status;
  //환불하였을때 상태를 알수있게끔
}
