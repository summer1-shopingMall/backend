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

  @NotNull
  private int stock;

  @NotNull
  private boolean status;

  @NotNull
  private Text spec;

  private Text content;

  private Text url;

  private int views;

  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
