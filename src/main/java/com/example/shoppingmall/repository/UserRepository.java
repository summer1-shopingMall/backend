package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  User getByUserId(String userId);

  Optional<User> findByEmail(String email);
}
