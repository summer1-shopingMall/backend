package com.example.shoppingmall.controller;

import com.example.shoppingmall.config.security.JwtTokenProvider;
import com.example.shoppingmall.dto.*;
import com.example.shoppingmall.service.CartService;
import com.example.shoppingmall.service.ProductService;
import com.example.shoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
  private final CartService cartService;
  private final UserService userService;
  private final ProductService productService;
  private final JwtTokenProvider jwtTokenProvider;

  @PostMapping()
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<CartResponseDto> insertOrder(HttpServletRequest request, @RequestParam Long productId) throws Exception {
    String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
    UserDto userDto = userService.userByUserId(userId);
    ProductDto productDto = productService.get(productId);

    System.out.println("[OrderController] userId" + userId);


    CartDto cartDto = new CartDto();
    cartDto.setProductId(productId);
    cartDto.setProductName(productDto.getProductName());
    cartDto.setUserId(userResponseDto.getUId());
    cartDto.setUserName(userResponseDto.getName());
    cartDto.setPrice(productResponseDto.getPrice());
    cartDto.setUrl(productResponseDto.getUrl());

    OrderResponseDto orderResponseDto = orderService.insertOrder(orderDto);
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);

  }

  @PostMapping("/ingredientsName")
  @PreAuthorize("hasAnyRole('ROLE_USER')")
  public ResponseEntity<OrderResponseDto> insertIngredients(HttpServletRequest request, @RequestParam String name) throws Exception {
    String userId = jwtTokenProvider.getUsername(request.getHeader("X-AUTH-TOKEN"));
    UserResponseDto userResponseDto = userService.userById(userId);
    IngredientsResponseDto ingredientsResponseDto = ingredientsService.getIngredientsName(name);

    System.out.println("[OrderController] userId" + userId);


    OrderDto orderDto = new OrderDto();
    orderDto.setProductId(ingredientsResponseDto.getNumber());
    orderDto.setProductName(name);
    orderDto.setUserId(userResponseDto.getUId());
    orderDto.setUserName(userResponseDto.getName());
    orderDto.setPrice(ingredientsResponseDto.getPrice());
    orderDto.setUrl(ingredientsResponseDto.getUrl());

    OrderResponseDto orderResponseDto = orderService.insertOrder(orderDto);
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);

  }

  @DeleteMapping()
  @PreAuthorize("hasAnyRole('ROLE_USER') or hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<String> deleteOrder(HttpServletRequest request, Long id) throws Exception {
    orderService.delectOrder(id);
    return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");

  }

  @GetMapping("/list")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<List<OrderResponseDto>> listAllOrder(HttpServletRequest request) {
    List<OrderResponseDto> orderResponseDtoList = orderService.listAllOrder();
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
  }

  @GetMapping("/listByProductId")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<List<OrderResponseDto>> listByProductId(HttpServletRequest request, @RequestParam Long pId) {
    List<OrderResponseDto> orderResponseDtoList = orderService.listOrderByProductId(pId);
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
  }

  @GetMapping("/listByUserId")
  @PreAuthorize("hasAnyRole('ROLE_USER') or hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<List<OrderResponseDto>> listByUserId(HttpServletRequest request, @RequestParam String uId) {
    List<OrderResponseDto> orderResponseDtoList = orderService.listOrderByUserId(uId);
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDtoList);
  }

  @GetMapping("/")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public ResponseEntity<OrderResponseDto> orderById(HttpServletRequest request, @RequestParam Long id) {
    OrderResponseDto orderResponseDto = orderService.selectOrder(id);
    return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
  }

}
