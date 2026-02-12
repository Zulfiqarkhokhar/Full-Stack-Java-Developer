package com.example.ChallangeApp.entity;

public class Challanges {

    private Long id;
    private String month;
    private String description;

    public Challanges(Long id, String description, String month) {
        this.id = id;
        this.description = description;
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
