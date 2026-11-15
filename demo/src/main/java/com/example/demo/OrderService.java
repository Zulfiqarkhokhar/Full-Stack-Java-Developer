package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    PaymentService paymentService;

//    @Autowired
//    OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }

    public void getDetails(){
        System.out.println("Order Details");
    }
}
