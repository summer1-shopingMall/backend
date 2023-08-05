package com.example.shoppingmall.mapper;

import com.example.shoppingmall.dto.CartDto;
import com.example.shoppingmall.dto.CartResponseDto;
import com.example.shoppingmall.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
  CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

  @Mapping(target = "id", ignore = true)  //id는 자동생성되므로 무시
  Cart dtoToEntity(CartDto cartDto);

  CartDto entityToDto(Cart cart);

  List<CartDto> entityListToDtoList(List<Cart> carts); // 리스트 변환

  CartResponseDto entityToResponseDto(Cart cart);
}
