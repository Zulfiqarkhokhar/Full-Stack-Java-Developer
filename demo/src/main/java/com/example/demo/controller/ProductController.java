package com.example.demo.controller;

import com.example.demo.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    OrderService orderService;

    ProductController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/Hello")
    public String hello(){
        orderService.placeOrder();
        return "hello";
    }
}
