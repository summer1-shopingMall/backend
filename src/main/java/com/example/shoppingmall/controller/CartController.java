package com.example.shoppingmall.controller;

import com.example.shoppingmall.config.security.JwtTokenProvider;
import com.example.shoppingmall.dto.*;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.ProductService;
import com.example.shoppingmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/cart")
public class CartController {
  private final CartService cartService;
  private final UserService userService;
  private final ProductService productService;
  private final JwtTokenProvider jwtTokenProvider;

  @Autowired
  public CartController(CartService cartService, UserService userService, ProductService productService, JwtTokenProvider jwtTokenProvider) {
    this.cartService = cartService;
    this.userService = userService;
    this.productService = productService;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @PostMapping("/insert")
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<CartResponseDto> insertCart(HttpServletRequest request, @RequestParam Long productId, @RequestParam int stock) throws Exception {
    String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
    UserResponseDto userResponseDto = userService.userByUserId(userId);
    ProductResponseDto productResponseDto = productService.getProduct(productId);

    System.out.println("[OrderController] userId" + userId);


    CartDto cartDto = new CartDto();
    cartDto.setProductId(productId);
    cartDto.setProductName(productResponseDto.getProductName());
    cartDto.setUserId(userResponseDto.getUserId());
    cartDto.setProductPrice(productResponseDto.getPrice());
    cartDto.setProductCount(stock);


    CartResponseDto cartResponseDto = cartService.insertCart(cartDto);
    return ResponseEntity.status(HttpStatus.OK).body(cartResponseDto);

  }

  @GetMapping("/listByUserId")
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<List<CartResponseDto>> listByUserId(HttpServletRequest request) {
    //로그인 시 로그인한 user의 cart list 출력
    String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
    UserResponseDto userResponseDto = userService.userByUserId(userId);

    System.out.println("[OrderController] userId" + userId);

    List<CartResponseDto> cartResponseDtoList = cartService.listOrderByUserId(userId);
    return ResponseEntity.status(HttpStatus.OK).body(cartResponseDtoList);
  }

  //상품 개수 수정


  @DeleteMapping("/delete")
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<String> deleteOrder(HttpServletRequest request, @RequestParam Long id) throws Exception {
    cartService.delectCart(id);
    return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

  }



}
