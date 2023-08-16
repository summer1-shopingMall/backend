package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/insertOrder")
    public ResponseEntity<Order> insertOrder(HttpServletRequest request, HttpSession session, Principal principal, @RequestParam String address)
    {
        HttpSession userId = request.getSession(false);
        if(userId != null)
        {
            String ins_Id = (String) userId.getAttribute("userId");
            String ins_name =  principal.getName();
            String ins_address = request.getParameter("address");
            ResponseEntity<Order> insertOrder = orderService.insertOrder(ins_Id,ins_name,ins_address);
            return ResponseEntity.ok(insertOrder).getBody();
        }
        return null;
    }
}
