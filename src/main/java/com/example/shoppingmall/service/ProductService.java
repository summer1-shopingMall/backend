package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
        List<Product> selectAllProduct();
        List<Product> searchProduct(String productName);
        List<Product> priceSort(String sortPrice);
        List<Product> searchCategory(String category);
        ResponseEntity<Product> insertProduct(String ins_category, String ins_productName, int ins_price, int ins_stock,
                                              int ins_status, int ins_cellCount, String ins_spec, String ins_content,
                                              String ins_url, String ins_createAt, String ins_updateAt);


}
