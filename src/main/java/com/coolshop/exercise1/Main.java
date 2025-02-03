package com.coolshop.exercise1;

public class Main {
    public static void main(String[] args) throws Exception {
        String res = Server.fetchProductsJson(); //Retriever JSON
        ProductService productService = new ProductService(res); //Passer JSON
        productService.allTogether();
    }
}

