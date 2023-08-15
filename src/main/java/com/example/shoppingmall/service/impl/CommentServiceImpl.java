package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.ProductComment;
import com.example.shoppingmall.entity.ProductQnA;
import com.example.shoppingmall.repository.CommentRepository;
import com.example.shoppingmall.repository.QnARepository;
import com.example.shoppingmall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final QnARepository qnARepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommentServiceImpl(QnARepository qnARepository, CommentRepository commentRepository) {
        this.qnARepository = qnARepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<ProductQnA> selectQnA() {
        return qnARepository.findAll();
    }

    @Override
    public List<ProductComment> selectComment() {
        return commentRepository.findAll();
    }
    @Override
    public ResponseEntity<ProductQnA> insertQnA(String userId, String text) {
        ProductQnA QnA = new ProductQnA();

        QnA.setUserName(userId);
        QnA.setText(text);

        ProductQnA insertQnA = qnARepository.save(QnA);
        return ResponseEntity.ok(insertQnA);
    }

    @Override
    public ResponseEntity<ProductComment> insertComment(String userId, String text) {
        ProductComment comment = new ProductComment();

        comment.setUserName(userId);
        comment.setText(text);

        ProductComment insertComment = commentRepository.save(comment);
        return ResponseEntity.ok(insertComment);
    }
}
