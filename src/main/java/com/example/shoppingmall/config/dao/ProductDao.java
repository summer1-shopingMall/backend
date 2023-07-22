package com.example.shoppingmall.config.dao;

import com.example.shoppingmall.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> selectAllProduct();
}
