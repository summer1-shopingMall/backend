package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.repository.OrderRepository;
import com.example.shoppingmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    private final OrderRepository orderRepository;

    @Autowired
    public SellerServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> SelectOrderList() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order updateStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null)
        {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
}
