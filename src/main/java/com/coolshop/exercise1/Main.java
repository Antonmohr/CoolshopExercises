package com.coolshop.exercise1;

public class Main {
    public static void main(String[] args) throws Exception {
        String res = Server.fetchProductsJson();
        ProductService productService = new ProductService(res);
        productService.allTogether();
    }
}

