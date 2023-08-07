package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.CartDto;
import com.example.shoppingmall.dto.CartResponseDto;
import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.repository.CartRepository;
import com.example.shoppingmall.service.CartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CartServiceImplTest {
  @InjectMocks
  private CartServiceImpl cartService;

  @Mock
  private CartRepository cartRepository;


  @Test
  void insertCart() {
      // Initialize Mockito
      MockitoAnnotations.initMocks(this);

      // Given
      CartDto cartDto = new CartDto();
      cartDto.setUserId(1L);
      cartDto.setProductId(101L);
      cartDto.setProductPrice(50000);
      cartDto.setProductCount(2);
      cartDto.setProductName("Test Product");

      Cart cart = new Cart();
      cart.setCartId(1L);
      cart.setUserId(cartDto.getUserId());
      cart.setProductId(cartDto.getProductId());
      cart.setProductPrice(cartDto.getProductPrice());
      cart.setProductCount(cartDto.getProductCount());
      cart.setProductName(cartDto.getProductName());
      cart.setUpdated_at(LocalDateTime.now());

      Mockito.when(cartRepository.save(Mockito.any(Cart.class))).thenReturn(cart);

      // When
      CartResponseDto result = cartService.insertCart(cartDto);

      // Then
      Assertions.assertNotNull(result);
      Assertions.assertEquals(cart.getCartId(), result.getId());
      Assertions.assertEquals(cart.getProductId(), result.getProductId());
      Assertions.assertEquals(cart.getProductPrice(), result.getProductPrice());
      Assertions.assertEquals(cart.getUserId(), result.getUserId());
      Assertions.assertEquals(cart.getProductCount(), result.getProductCount());
      Assertions.assertEquals(cart.getProductName(), result.getProductName());

    }
//
//  @Test
//  void delectCart() throws Exception {
//    Long idToDelete = 1L; // Set the ID to delete
//
//    CartRepository cartRepository = new MockCartRepository();
//    CartService cartService = new CartServiceImpl(cartRepository);
//
//    // When
//    cartService.delectCart(idToDelete);
//
//    // No explicit assertions, since we are testing for exceptions
//  }

//  @Test
//  void selectCart() {
//    Long idToSelect = 1L; // Set the ID to select
//
//    Cart cart = new Cart();
//    // Set cart properties
//    cart.setCartId(idToSelect);
//
//    CartRepository cartRepository = new MockCartRepository(cart);
//    CartService cartService = new CartServiceImpl(cartRepository);
//
//    // When
//    CartResponseDto result = cartService.selectCart(idToSelect);
//
//    // Then
//    // Add assertions to check the correctness of the result
//  }
//
//  @Test
//  void listOrderByUserId() {
//    Long userId = 1L; // Set the user ID
//
//    List<Cart> cartList = new ArrayList<>();
//    // Add cart objects to the cartList
//
//    CartRepository cartRepository = new MockCartRepository(cartList);
//    CartService cartService = new CartServiceImpl(cartRepository);
//
//    // When
//    List<CartResponseDto> result = cartService.listOrderByUserId(userId);
//
//    // Then
//    // Add assertions to check the correctness of the result
//  }
//
//  @Repository
//  public class MockCartRepository implements CartRepository {
//    private final List<Cart> cartList;
//
//    public MockCartRepository() {
//      this.cartList = new ArrayList<>();
//    }
//
//    public MockCartRepository(Cart cart) {
//      this.cartList = new ArrayList<>();
//      this.cartList.add(cart);
//    }
//
//    public MockCartRepository(List<Cart> cartList) {
//      this.cartList = cartList;
//    }
//
//    @Override
//    public List<Cart> findByUserId(Long userId) {
//      List<Cart> userCarts = new ArrayList<>();
//      for (Cart cart : cartList) {
//        if (cart.getUserId().equals(userId)) {
//          userCarts.add(cart);
//        }
//      }
//      return userCarts;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//      cartList.removeIf(cart -> cart.getCartId().equals(id));
//    }
//
//    @Override
//    public Cart getById(Long id) {
//      Optional<Cart> cartOptional = cartList.stream()
//          .filter(cart -> cart.getCartId().equals(id))
//          .findFirst();
//      return cartOptional.orElse(null);
//    }
//
//    @Override
//    public <S extends Cart> List<S> findAll(Example<S> example, Sort sort) {
//      // Implement the findAll method if needed
//      // For now, you can return an empty list or throw an UnsupportedOperationException
//      return new ArrayList<>();
//    }
//    @Override
//    public <S extends Cart> List<S> findAll(Example<S> example) {
//      return new ArrayList<>();
//    }
//  }
}