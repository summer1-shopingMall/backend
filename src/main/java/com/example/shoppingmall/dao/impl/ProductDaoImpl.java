package com.example.shoppingmall.dao.impl;

import com.example.shoppingmall.dao.ProductDao;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao
{
    private final ProductRepository productRepository;

    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> selectAllProduct()
    {
        return  productRepository.findAll();
    }
}
