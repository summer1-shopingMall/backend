package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //셀러로 주문 뽑아오기
    List<Order> findBySeller(Seller seller);
    //상품을 샀는지 안샀는지 체크
    boolean existsByUserName(String userName);
}
