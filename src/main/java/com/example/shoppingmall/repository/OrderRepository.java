package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
