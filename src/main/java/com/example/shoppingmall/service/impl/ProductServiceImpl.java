package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> selectProduct = productRepository.findAll();
        System.out.println("서비스에서"+selectProduct);
        return selectProduct;
    }

    @Override
    public List<Product> searchProduct(String productName) {
        List<Product> searchProduct = productRepository.findByproductName(productName);
        System.out.println("서비스에서"+searchProduct);
        return searchProduct;
    }

    @Override
    public List<Product> priceSort(String sortPrice) {
        if(sortPrice.equals("내림차순")) {
            List<Product> priceSort = productRepository.findByOrderByPriceDesc();
            System.out.println("서비스에서"+priceSort);
            return priceSort;
        }else
        {
            List<Product> priceSort = productRepository.findByOrderByPriceAsc();
            System.out.println("서비스에서"+priceSort);
            return priceSort;
        }
    }

    @Override
    public List<Product> searchCategory(String category) {
        List<Product> searchCategory = productRepository.findBycategory(category);
        System.out.println("서비스에서"+searchCategory);
        return searchCategory;
    }

}
