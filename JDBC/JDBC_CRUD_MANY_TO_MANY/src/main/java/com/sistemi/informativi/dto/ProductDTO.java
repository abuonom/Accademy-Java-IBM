package com.sistemi.informativi.dto;

public class ProductDTO {
    private String name;
    private float price;

    public ProductDTO(String string, float v) {
        this.name = string;
        this.price = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
