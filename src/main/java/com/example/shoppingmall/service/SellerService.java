package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Order;

import java.util.List;

public interface SellerService {
    List<Order> SelectOrderList();
    Order updateStatus(Long id, String status);
}
