package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.entity.Seller;
import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    private final SellerService sellerService;
    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/orderList")
    public ResponseEntity<List<Order>> SelectOrderList(Authentication authentication)
    {
        Seller seller = (Seller)authentication.getPrincipal();
        List<Order>selectOrderList = sellerService.SelectOrderList(seller);
        return new ResponseEntity<>(selectOrderList, HttpStatus.OK);
    }

    @GetMapping("/updateOrder")
    public ResponseEntity<Order> UpdateOrder(HttpServletRequest request, @RequestParam Long id ,@RequestParam String status)
    {
        Long upt_id = Long.valueOf(request.getParameter("id"));
        String upt_status = request.getParameter("status");
        Order order = sellerService.updateStatus(upt_id,upt_status);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
