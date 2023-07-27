package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String category;

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

  @NotNull
  private Text spec;

  private Text content;

  private Text url;

  private int views;

  private boolean like1;
  //찜 기능(이게 좋다 이런거)

  private LocalDateTime createdAt;
  //상품 등록 날자
  private LocalDateTime updatedAt;
  //상품 수정 날자
}
