package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.Seller;
import com.example.shoppingmall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller getBySellerID(String sellerID);
}
