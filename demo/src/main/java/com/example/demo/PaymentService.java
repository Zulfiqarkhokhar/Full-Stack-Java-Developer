package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    // in spring boot this called circular dependency

    @Autowired
    OrderService orderService;

//    @Autowired
//    PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }

    public void pay(){
        System.out.println("Payment Done");
        orderService.getDetails();
    }
}
