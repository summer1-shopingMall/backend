package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.ProductComment;
import com.example.shoppingmall.entity.ProductQnA;
import com.example.shoppingmall.service.CommentService;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final ProductService productService;
    @Autowired
    public CommentController(CommentService commentService, ProductService productService) {
        this.commentService = commentService;
        this.productService = productService;
    }

    @PostMapping("/selectQnA")
    public List<ProductQnA> selectQnA(HttpSession session)
    {
        Long productId = (Long) session.getAttribute("productId");
        List<ProductQnA> selectQnA = commentService.selectQnA(productId);
        return selectQnA;
    }

    @PostMapping("/selectComment")
    public List<ProductComment> selectComment(HttpSession session)
    {
        Long productId = (Long) session.getAttribute("productId");
        List<ProductComment> selectComment = commentService.selectComment(productId);
        return selectComment;
    }

    @PostMapping("/insertQnA")
    public ResponseEntity<ProductQnA> insertQnA(HttpServletRequest request, Principal principal, HttpSession session, @RequestParam String text)
    {

        ResponseEntity<ProductQnA> insertQnA = null;
        System.out.println(principal);
        if (principal != null)
        {
            Long productId = (Long) session.getAttribute("productId");
            String ins_name = principal.getName();
            String ins_text = request.getParameter("text");
            insertQnA = commentService.insertQnA(productId,ins_name, ins_text);
        }else
        {
            System.out.println("로그인을 먼저 해주세요");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(insertQnA).getBody();
    }

    @PostMapping("/insertComment")
    public ResponseEntity<ProductComment> insertComment(HttpServletRequest request, Principal principal, HttpSession session, @RequestParam String text)
    {
        ResponseEntity<ProductComment> insertComment = null;
        if (principal != null)
        {
            Long productId = (Long) session.getAttribute("productId");
            String ins_name =  principal.getName();
            String ins_text = request.getParameter("text");
            boolean checkProduct = productService.checkProduct(ins_name);
            if (checkProduct)
            {
                insertComment = commentService.insertComment(productId, ins_name, ins_text);
            }else
            {
                System.out.println("로그인을 먼저 해주세요");
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(insertComment).getBody();
    }
}
