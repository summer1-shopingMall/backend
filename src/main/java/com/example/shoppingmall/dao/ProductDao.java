package com.example.shoppingmall.dao;

import com.example.shoppingmall.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> selectAllProduct();
    List<Product> searchProduct(String productName);
    List<Product> priceSort(String sortPrice);
    List<Product> searchCategory(String category);

}
