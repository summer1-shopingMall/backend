package com.example.shoppingmall.service;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.entity.Seller;

import java.util.List;

public interface SellerService {
    List<Order> SelectOrderList(Seller seller);
    Order updateStatus(Long id, String status);
}
