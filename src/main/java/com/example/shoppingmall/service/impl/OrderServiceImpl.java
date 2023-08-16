package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.repository.OrderRepository;
import com.example.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseEntity<Order> insertOrder(String ins_Id, String ins_name, String ins_address) {
        Order order = new Order();

        order.setUserId(ins_Id);
        order.setUserName(ins_name);
        order.setAddress1(ins_address);

        Order insertOrder = orderRepository.save(order);
        return ResponseEntity.ok(insertOrder);
    }
}
