package com.example.shoppingmall.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "productComment")
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private String userId;

    private String text;
}
