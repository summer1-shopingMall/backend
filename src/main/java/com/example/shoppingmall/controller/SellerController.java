package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    private final SellerService sellerService;
    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/orderList")
    public List<Order> SelectOrderList()
    {
        List<Order>selectOrderList = sellerService.SelectOrderList();
        return selectOrderList;
    }

    @GetMapping("/updateOrder")
    public ResponseEntity<Order> UpdateOrder(HttpServletRequest request, @RequestParam Long id ,@RequestParam String status)
    {
        Long upt_id = Long.valueOf(request.getParameter("id"));
        String upt_status = request.getParameter("status");
        Order order = sellerService.updateStatus(upt_id,upt_status);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
