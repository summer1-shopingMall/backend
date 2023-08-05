package com.example.shoppingmall.entity;


import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "refund")
public class Refund {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Long orderDetailId;

  @NotNull
  private String reason;

  private Text url;

  @NotNull
  private Long userId;


}
