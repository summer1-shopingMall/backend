package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.ProductDto;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listProduct")
    public List<Product> SelectAllProduct()
    {
        List<Product> mainPageProduct = productService.selectAllProduct();
        return mainPageProduct;
    }

    @GetMapping("/searchProduct")
    public List<Product> SearchProduct(HttpServletRequest request)
    {
        String productName = request.getParameter("productName");
        List<Product> searchProduct = productService.searchProduct(productName);
        return searchProduct;
    }
    @GetMapping("/priceSort")
    public List<Product> priceSort(HttpServletRequest request)
    {
        String sortPrice = request.getParameter("sort");
        List<Product> priceSort = productService.priceSort(sortPrice);
        return priceSort;
    }

    @GetMapping("/searchCategory")
    public List<Product> searchCategory(HttpServletRequest request)
    {
        String category = request.getParameter("category");
        List<Product> searchCategory = productService.searchCategory(category);
        return searchCategory;
    }
}
