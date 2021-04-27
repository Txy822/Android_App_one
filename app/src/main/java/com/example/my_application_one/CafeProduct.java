package com.example.my_application_one;

public class CafeProduct {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getApiID() {
        return apiID;
    }

    public void setApiID(Integer apiID) {
        this.apiID = apiID;
    }

    private Integer apiID;

    CafeProduct(String name, Integer apiID) {
        this.name = name;
        this.apiID = apiID;
    }

    public String toString() {
        return this.name;
    }

}
