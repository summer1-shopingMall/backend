package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;

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
