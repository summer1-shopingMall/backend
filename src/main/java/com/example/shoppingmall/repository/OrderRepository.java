package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllBySellerId(String sellerId);
    boolean existsByUserId(String userId);
}
