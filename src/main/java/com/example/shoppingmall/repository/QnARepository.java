package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.ProductQnA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnARepository extends JpaRepository<ProductQnA, Long> {
    List<ProductQnA> findAllByProductId(Long productId);
}
