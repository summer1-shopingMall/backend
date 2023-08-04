package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<Product> insertProduct(String ins_category, String ins_productName, int ins_price, int ins_stock,
                                                 int ins_status, int ins_cellCount, String ins_spec, String ins_content,
                                                 String ins_url, String ins_createAt, String ins_updateAt)
    {
        Product product = new Product();
        product.setCategory(ins_category);
        product.setProductName(ins_productName);
        product.setPrice(ins_price);
        product.setStock(ins_stock);
        product.setStatus(ins_status);
        product.setCellCount(ins_cellCount);
        product.setSpec(ins_spec);
        product.setContent(ins_content);
        product.setUrl(ins_url);
        product.setCreatedAt(ins_createAt);
        product.setUpdatedAt(ins_updateAt);

        Product insertProduct = productRepository.save(product);

        return ResponseEntity.ok(insertProduct);
    }

}
