package com.example.shoppingmall.entity;


import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "inquiry")
public class Inquiry {
  //문의 테이블
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Long productId;

  @NotNull
  private Text content;

  @NotNull
  private Long userId;

  private LocalDateTime inquiryDate;

  private Long inquiryOrginId;
  private int inquiryOrder;
  private int inquiryDepth;
}
