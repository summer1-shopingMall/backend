package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<Order> insertOrder(String ins_Id,String ins_name,String ins_address);

    void moveCartToOrders(String userId);
}
