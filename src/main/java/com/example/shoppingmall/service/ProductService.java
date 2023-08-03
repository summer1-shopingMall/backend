package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Product;

import java.util.List;

public interface ProductService {
        List<Product> selectAllProduct();
        List<Product> searchProduct(String productName);
        List<Product> priceSort(String sortPrice);
        List<Product> searchCategory(String category);


}
