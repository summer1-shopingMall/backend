package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.config.dao.ProductDao;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> selectAllProduct() {
        return productDao.selectAllProduct();
    }
}
