package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.ProductComment;
import com.example.shoppingmall.entity.ProductQnA;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<ProductQnA> insertQnA(String userId, String text);
    ResponseEntity<ProductComment> insertComment(String userId, String text);
    List<ProductQnA> selectQnA();
    List<ProductComment> selectComment();
}
