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
  //판매자 입장에서 보이는 테이블
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "seller_id", nullable = false)
  private Seller seller;
  //제품 관련 정보
  @NotNull
  private Long productId;
  @NotNull
  private int productPrice;
  @NotNull
  private int productCount;
  
  // 유저 정보
  @NotNull
  private String userId;

  private String userName;
  @NotNull
  private String address1;
  @NotNull
  private String address2;

  private String address3;
  
  //배송받는 사람 정보
  private String receiverName;

  private String receiverPhone;

  //배송 상태
  private int status;

  //주문취소 상태 알림
  private boolean refundCheck;

  private LocalDateTime orderDate;

}
