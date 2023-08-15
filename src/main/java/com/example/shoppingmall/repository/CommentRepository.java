package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<ProductComment, Long> {
}
