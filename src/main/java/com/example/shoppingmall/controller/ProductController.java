package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.ProductDto;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listProduct")
    public String SelectAllProduct(Model model)
    {
        List<Product> mainPageProduct = productService.selectAllProduct();
        model.addAttribute("product", mainPageProduct);
        return "main";
    }
}
