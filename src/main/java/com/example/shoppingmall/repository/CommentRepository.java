package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.ProductComment;
import com.example.shoppingmall.entity.ProductQnA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findAllByProductId(Long productId);

}
