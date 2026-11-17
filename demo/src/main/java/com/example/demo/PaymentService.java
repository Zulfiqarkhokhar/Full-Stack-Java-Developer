package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private PaymentProperties paymentProperties;

    @Autowired
    PaymentService(PaymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }

    public String getPaymentType(){
        return paymentProperties.getType();
    }

    public int getPaymentRetryCount(){
        return paymentProperties.getRetryCount();
    }

    public int getPaymentTimeout(){
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println(paymentProperties.getType());
        System.out.println(paymentProperties.getRetryCount());
        System.out.println(paymentProperties.getTimeout());
    }

    public PaymentDTO sendResponse(){
        return new PaymentDTO(paymentProperties.getType(),paymentProperties.getRetryCount(),paymentProperties.getTimeout());
    }
}
