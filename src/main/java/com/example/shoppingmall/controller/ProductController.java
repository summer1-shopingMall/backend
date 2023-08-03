package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listProduct")
    public List<Product> SelectAllProduct()
    {
        List<Product> selectProduct = productService.selectAllProduct();
        System.out.println("컨트롤러에서"+selectProduct);
        return selectProduct;
    }
    @GetMapping("/searchProduct")
    public List<Product> SearchProduct(HttpServletRequest request)
    {
        //이게 웹페이지에서 받아오는거
        //String productName = request.getParameter("productName");

        //이건 테스트해볼려고 하는거
        String a = "옷";
        List<Product> searchProduct = productService.searchProduct(a);
        System.out.println("컨트롤러에서"+searchProduct);
        return searchProduct;
    }
    @GetMapping("/priceSort")
    public List<Product> priceSort(HttpServletRequest request)
    {
        //이게 웹페이지에서 받아오는거
        //String sortPrice = request.getParameter("sort");

        //이건 테스트해볼려고 하는거
        String a = "내림차순";
        List<Product> priceSort = productService.priceSort(a);
        System.out.println("컨트롤러에서"+priceSort);
        return priceSort;
    }

    @GetMapping("/searchCategory")
    public List<Product> searchCategory(HttpServletRequest request)
    {
        //이게 웹페이지에서 받아오는거
        //String category = request.getParameter("category");

        //이건 테스트해볼려고 하는거
        String a = "모자";
        List<Product> searchCategory = productService.searchCategory(a);
        System.out.println("컨트롤러에서"+searchCategory);
        return searchCategory;
    }

}
