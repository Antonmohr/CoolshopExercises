package com.coolshop.exercise1;

import java.util.List;

public class Product {

    private String id;
    private String title;
    private String description;
    private List<String> category;
    private double price;
    private String stock_status;
    private Dimensions dimensions;

    public Product(String id, String title, String description, List<String> category, double price, String stock_status, Dimensions dimensions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock_status = stock_status;
        this.dimensions = dimensions;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getStock_status() {
        return stock_status;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", stock_status='" + stock_status + '\'' +
                ", dimensions=" + dimensions +
                '}';
    }
}
