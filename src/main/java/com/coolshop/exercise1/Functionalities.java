package com.coolshop.exercise1;
import com.google.gson.Gson;
import java.util.ArrayList;

public class Functionalities {
    ProductList productList;

    public Functionalities(String json) {
        Gson gson = new Gson();
        this.productList = gson.fromJson(json, ProductList.class);

    }

    public String findIdOfHighest(){

        double highest = productList.getProducts().get(0).getPrice();
        String highestID = productList.getProducts().get(0).getId();
        for(Product product : productList.getProducts()){
            double currentPrice = product.getPrice();
            if(currentPrice>= highest){
                highest = currentPrice;
                highestID = product.getId();
            }
        }

        return highestID;
    }

    public int LowestPrice(){
        int lowest = productList.getProducts().get(0).getPrice();

        for(Product product : productList.getProducts()){
            int currentPrice = product.getPrice();
            if(currentPrice<=lowest){
                lowest = currentPrice;
            }
        }
        return lowest;
    }

    public ArrayList<String>IdOfStock(){
        ArrayList<String>inStock = new ArrayList<>();
        for(Product product: productList.getProducts()){
            if(product.getStock_status().equals("in_stock")){
                inStock.add(product.getId());
            }
        }
        return inStock;
    }

    public double avgVolume(){
        double totalVolume = 0;
        double currentVolume;
        for(Product product: productList.getProducts()){
            Dimensions currentDimension = product.getDimensions();
            currentVolume = currentDimension.getHeight_mm()*currentDimension.getLength_mm()*currentDimension.getWidth_mm();
            totalVolume += currentVolume;
        }

        double averageVolumeCM =  (totalVolume / 100) / productList.getProducts().size();
        return averageVolumeCM;
    }

    public void AllTogether(){
        System.out.println("Lowest price: " + this.LowestPrice());
        System.out.println("_________________________________");
        System.out.println("Id of highest price product: " + this.findIdOfHighest());
        System.out.println("_________________________________");
        System.out.println("id's of products in stock: " + this.IdOfStock());
        System.out.println("_________________________________");
        System.out.println("Average colume in cm3: "+ this.avgVolume());
    }
}
