package com.example.shoppingmall.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
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

    private LocalDateTime created_at;

    private LocalDateTime updatedAt;
}
