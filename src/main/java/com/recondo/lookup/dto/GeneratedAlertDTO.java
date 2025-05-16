package com.recondo.lookup.dto;

public class GeneratedAlertDTO {
    private String product;
    private String text;
    private String key; // New property

    // Getters and Setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Optional: Override toString for easier debugging
    @Override
    public String toString() {
        return "GeneratedAlertDTO{" +
                "product='" + product + '\'' +
                ", text='" + text + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
