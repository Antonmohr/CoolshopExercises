package com.coolshop.exercise1;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter



public class Product {

    private String id;
    private String title;
    private String description;
    private List<String> category;
    private int price;
    private String stock_status;
    private Dimensions dimensions;


    public Product(String id, String title, String Description, List<String> category, int price, String stock_status, Dimensions dimensions){
        this.id = id;
        this.title = title;
        this.description = Description;
        this.category = category;
        this.price = price;
        this.stock_status = stock_status;
        this.dimensions = dimensions;
    }

    public Product(){

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
