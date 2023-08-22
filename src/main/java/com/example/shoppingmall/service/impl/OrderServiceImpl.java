package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.repository.OrderRepository;
import com.example.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public ResponseEntity<Order> insertOrder(String ins_Id, String ins_name, String ins_address) {
        Order order = new Order();

        order.setUserId(ins_Id);
        order.setUserId(ins_name);
        order.setAddress1(ins_address);

        Order insertOrder = orderRepository.save(order);
        return ResponseEntity.ok(insertOrder);
    }

    @Override
    public void moveCartToOrders(String userId) {
        List<Cart> cartList = cartRepository.findByUserId(userId);

        List<Order> orders = new ArrayList<>();
        for(Cart cart : cartList){
            Order order = new Order();
            //order.set
        }
    }
}