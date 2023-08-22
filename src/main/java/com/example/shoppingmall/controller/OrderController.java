package com.example.shoppingmall.controller;

import com.example.shoppingmall.entity.Order;
import com.example.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/insertOrder")
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

//    @PostMapping("/insertCartList")
//    public ResponseEntity<String> insertCartList(@RequestBody List<Order> dataList) {
//        try {
//            List<YourEntity> insertedData = yourService.insertListToDb(dataList);
//            return ResponseEntity.ok("데이터가 성공적으로 입력되었습니다. 입력된 개수: " + insertedData.size());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류가 발생했습니다: " + e.getMessage());
//        }
//    }
}
