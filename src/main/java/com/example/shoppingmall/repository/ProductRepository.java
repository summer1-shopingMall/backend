package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByproductNameLike(String productName);
    List<Product> findByOrderByPriceDesc();
    List<Product> findByOrderByPriceAsc();
    List<Product> findBycategory(String category);
}
