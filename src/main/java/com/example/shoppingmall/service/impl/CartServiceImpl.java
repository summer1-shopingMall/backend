package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.CartDto;
import com.example.shoppingmall.dto.CartResponseDto;
import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
  private final CartRepository cartRepository;

  @Override
  public CartResponseDto insertCart(CartDto cartDto) {
    Cart cart = new Cart();
    cart.setUserId(cartDto.getUserId());
    cart.setProductId(cartDto.getProductId());
    cart.setProductPrice(cartDto.getProductPrice());
    cart.setProductCount(cartDto.getProductCount());
    cart.setProductName(cartDto.getProductName());
    cart.setUpdated_at(LocalDateTime.now());

    Cart saveCart = cartRepository.save(cart);

    CartResponseDto cartResponseDto = new CartResponseDto();
    cartResponseDto.setId(saveCart.getId());
    cartResponseDto.setProductId(saveCart.getProductId());
    cartResponseDto.setProductPrice(saveCart.getProductPrice());
    cartResponseDto.setUserId(saveCart.getUserId());
    cartResponseDto.setProductCount(saveCart.getProductCount());
    cartResponseDto.setProductName(saveCart.getProductName());
    return cartResponseDto;
  }

  @Override
  public void delectCart(Long id) throws Exception {
    cartRepository.deleteById(id);
  }

  @Override
  public CartResponseDto selectCart(Long id) {
    Cart cart = cartRepository.getById(id);
    CartResponseDto cartResponseDto = new CartResponseDto(cart);
    return cartResponseDto;
  }

  @Override
  public List<CartResponseDto> listOrderByUserId(String userId) {
    List<Cart> cartList = cartRepository.findByUserId(userId);
    List<CartResponseDto> cartResponseDtos = cartList
        .stream()
        .map(CartResponseDto::new)
        .collect(Collectors.toList());
    return cartResponseDtos;
  }
}
