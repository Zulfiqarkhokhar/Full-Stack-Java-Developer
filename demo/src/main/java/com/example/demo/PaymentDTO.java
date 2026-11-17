package com.example.demo;

public class PaymentDTO {
    private String type;
    private int retryCount;
    private int timeout;

    public PaymentDTO(String type, int retryCount, int timeout) {
        this.type = type;
        this.retryCount = retryCount;
        this.timeout = timeout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
