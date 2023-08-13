package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.dto.CartResponseDto;
import com.example.shoppingmall.dto.ProductResponseDto;
import com.example.shoppingmall.entity.Cart;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<Product> searchProduct = productRepository.findByproductNameLike("%"+productName+"%");
        System.out.println("서비스에서"+searchProduct);
        return searchProduct;   //변경테스트
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

    @Override
    @Transactional
    public Product updateProduct(Long upt_id, String upt_category, String upt_productName, int upt_price,
                                 int upt_stock, int upt_status, int upt_cellCount, String upt_spec,
                                 String upt_content, String upt_url, String upt_updateAt)
    {
        Product product = productRepository.findById(upt_id).orElse(null);
        if (product != null)
        {
            product.setCategory(upt_category);
            product.setProductName(upt_productName);
            product.setPrice(upt_price);
            product.setStatus(upt_status);
            product.setCellCount(upt_cellCount);
            product.setSpec(upt_spec);
            product.setStock(upt_stock);
            product.setContent(upt_content);
            product.setUrl(upt_url);
            product.setUpdatedAt(upt_updateAt);

            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public ProductResponseDto getProduct(Long id) {
        Product product = productRepository.getById(id);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setCategory(product.getCategory());
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());
        productResponseDto.setStatus(product.getStatus());
        productResponseDto.setCellCount(product.getCellCount());
        productResponseDto.setSpec(product.getSpec());
        productResponseDto.setContent(product.getContent());
        productResponseDto.setUrl(product.getUrl());
        productResponseDto.setViews(product.getViews());

        return productResponseDto;
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id){
        try
        {
            productRepository.deleteById(id);
            return ResponseEntity.ok("삭제 완료");
        }catch (Exception e)
        {
            return ResponseEntity.ok("삭제 불가");
        }
    }
}
