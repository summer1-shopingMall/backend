package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByproductName(String productName);
    List<Product> findByOrderByPriceDesc();
    List<Product> findByOrderByPriceAsc();
    List<Product> findBycategory(String category);

}
