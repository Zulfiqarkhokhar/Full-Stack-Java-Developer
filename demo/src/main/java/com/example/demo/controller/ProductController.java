package com.example.demo.controller;

import com.example.demo.OrderService;
import com.example.demo.PaymentDTO;
import com.example.demo.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    PaymentService paymentService;

    ProductController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/Hello")
    public PaymentDTO hello(){
        return paymentService.sendResponse();
    }
}
