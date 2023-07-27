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

    @Override
    public List<Product> searchProduct(String productName) {
        return productRepository.findByproductName(productName);
    }

    @Override
    public List<Product> priceSort(String sortPrice) {
        String sortDesc = "높은 가격순";
        if(sortDesc.equals(sortPrice))
        {
            return productRepository.findByOrderByPriceDesc();
        }
        return productRepository.findByOrderByPriceAsc();
    }

    @Override
    public List<Product> searchCategory(String category) {
        return productRepository.findBycategory(category);
    }
}
