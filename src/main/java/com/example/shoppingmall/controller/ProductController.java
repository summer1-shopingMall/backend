package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/listProduct")//상품 전체출력
    public List<Product> SelectAllProduct()
    {
        List<Product> selectProduct = productService.selectAllProduct();
        System.out.println("컨트롤러에서"+selectProduct);
        return selectProduct;
    }
    @GetMapping("/searchProduct")//상품이름 검색
    public List<Product> SearchProduct(HttpServletRequest request, @RequestParam String productName)
    {
        String searchProductName = request.getParameter("productName");

        List<Product> searchProduct = productService.searchProduct(searchProductName);
        System.out.println("컨트롤러에서"+searchProduct);
        return searchProduct;
    }
    @GetMapping("/priceSort")//가격 오름차순, 내림차순 정렬
    public List<Product> priceSort(HttpServletRequest request, @RequestParam String sort)
    {
        String sortPrice = request.getParameter("sort");

        List<Product> priceSort = productService.priceSort(sortPrice);
        System.out.println("컨트롤러에서"+priceSort);
        return priceSort;
    }

    @GetMapping("/searchCategory")//카테고리 검색
    public List<Product> searchCategory(HttpServletRequest request, @RequestParam String category)
    {
        String categoryName = request.getParameter("category");

        List<Product> searchCategory = productService.searchCategory(categoryName);
        System.out.println("컨트롤러에서"+searchCategory);
        return searchCategory;
    }

    @GetMapping("/insertProduct")//상품 등록
    public ResponseEntity<Product> insertProduct(HttpServletRequest request, @RequestParam String category, @RequestParam String productName, @RequestParam int price,
                                        @RequestParam int stock, @RequestParam int status, @RequestParam int cellCount, @RequestParam String spec,
                                        @RequestParam String content, @RequestParam String url)
    {
        String ins_category = request.getParameter("category");
        String ins_productName = request.getParameter("productName");
        int ins_price = Integer.parseInt(request.getParameter("price"));
        int ins_stock = Integer.parseInt(request.getParameter("stock"));
        int ins_status = Integer.parseInt(request.getParameter("status"));
        int ins_cellCount = Integer.parseInt(request.getParameter("cellCount"));
        String ins_spec = request.getParameter("spec");
        String ins_content = request.getParameter("content");
        String ins_url = request.getParameter("url");
        //시간
        LocalDateTime beforeDate = LocalDateTime.now();
        DateTimeFormatter afterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ins_createAt = beforeDate.format(afterDate);
        String ins_updateAt = beforeDate.format(afterDate);

       Product insertProduct = productService.insertProduct(ins_category, ins_productName, ins_price, ins_stock,
                ins_status, ins_cellCount, ins_spec, ins_content, ins_url, ins_createAt, ins_updateAt).getBody();

        return ResponseEntity.ok(insertProduct);
    }


}
