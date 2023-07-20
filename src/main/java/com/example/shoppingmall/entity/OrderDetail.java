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
  //제품번호

  @NotNull
  private Long productId;

  private int price;

  @NotNull
  private int count;

  @NotNull
  private String status;
  //배송중인지 결제가되었는지 상태를 보여준다

  private boolean refundCheck;
  //주문취소 상태 알림
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
