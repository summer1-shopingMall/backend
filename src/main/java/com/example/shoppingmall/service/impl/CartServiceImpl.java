package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.CartDto;
import com.example.shoppingmall.dto.CartResponseDto;
import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.mapper.CartMapper;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;
  private final CartMapper cartMapper;

  @Autowired
  public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
    this.cartRepository = cartRepository;
    this.cartMapper = cartMapper;
  }




  @Override
  public CartResponseDto insertCart(CartDto cartDto) {
    Cart cart = cartMapper.dtoToEntity(cartDto);

    Cart savedCart = cartRepository.save(cart);

    return cartMapper.entityToResponseDto(savedCart);
  }

  @Override
  public void delectCart(Long id) throws Exception {
    Optional<Cart> cartOptional = cartRepository.findById(id);
    if (!cartOptional.isPresent()) {
      throw new Exception("Cart not found with id: " + id);
    }
    cartRepository.deleteById(id);
  }

  @Override
  public CartDto selectCart(Long id) {
    Optional<Cart> cartOptional = cartRepository.findById(id);
    return cartOptional.map(cartMapper::entityToDto).orElse(null);
  }

  @Override
  public List<CartDto> listOrderByUserId(Long userId) {
    List<Cart> carts = cartRepository.findByUserId(userId);
    return cartMapper.entityListToDtoList(carts);
  }
}
