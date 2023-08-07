package com.example.shoppingmall.dto;

import com.example.shoppingmall.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDto {
  private Long id;

  private String category;

  private String productName;

  private int price;

  private int stock;

  private int status;

  private int cellCount;

  private String spec;

  private String content;

  private String url;

  private int views;

  public ProductResponseDto() {
  }

  public ProductResponseDto(Product product) {
    this.id = product.getId();
    this.category = product.getCategory();
    this.productName = product.getProductName();
    this.price = product.getPrice();
    this.stock = product.getStock();
    this.status = product.getStatus();
    this.cellCount = product.getCellCount();
    this.spec = product.getSpec();
    this.content = product.getContent();
    this.url = product.getUrl();
    this.views = product.getViews();
  }
}
