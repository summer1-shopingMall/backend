package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.ProductQnA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnARepository extends JpaRepository<ProductQnA, Long> {
}
