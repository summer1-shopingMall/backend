package com.example.shoppingmall.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "productQnA")
public class ProductQnA{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String text;
}
