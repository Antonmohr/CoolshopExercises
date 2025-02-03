package com.coolshop.exercise1;
import com.google.gson.Gson;
import java.util.ArrayList;


class ProductService {
    ProductList productList;

    //mapper JSON til Productlist-object
    public ProductService(String json) {
        Gson gson = new Gson();
        this.productList = gson.fromJson(json, ProductList.class);
        for(Product product: productList.getProducts()){
            product.setPrice(product.getPrice()/100); //Dividerer med 100, for at konvertere øreprisen i JSON til kroner.
        }
    }

    // Finder ID for det dyreste produkt
    public String findIdOfHighest(){

        if(productList.getProducts().isEmpty()){
            return "No products available";
        }

        double highest = productList.getProducts().get(0).getPrice();
        String highestID = productList.getProducts().get(0).getId();
        for(Product product : productList.getProducts()){
            double currentPrice = product.getPrice();
            if(currentPrice> highest){
                highest = currentPrice;
                highestID = product.getId();
            }
        }

        return highestID;
    }
     // Finder den laveste pris blandt produkterne
    public double getLowestPrice(){
        if(productList.getProducts().isEmpty()){
            return 0; // Returnerer 0, hvis der ikke er produkter
        }
        double lowest = productList.getProducts().get(0).getPrice();

        for(Product product : productList.getProducts()){
            double currentPrice = product.getPrice();
            if(currentPrice<lowest){
                lowest = currentPrice;
            }
        }
        return lowest;
    }
    // Returnerer en liste over IDs på produkter, der er på lager
    public ArrayList<String>getIdsOfInStock(){
        ArrayList<String>inStock = new ArrayList<>();
        
        for(Product product: productList.getProducts()){
            if(product.getStock_status()!= null && product.getStock_status().equals("in_stock")){ //tjekker det ikke er null for at undgå NULLpointerexception, hvis fejl i JSON feed
                inStock.add(product.getId());
            }
        }
        return inStock;
    }
    // Beregner gennemsnitligt volumen i cm³
    public double getAvgVolume(){

        if(productList.getProducts().size() == 0){
            return 0; // for at undgå DivideByZeroException
        }
        double totalVolume = 0;
        double currentVolume;
        for(Product product: productList.getProducts()){
            Dimensions currentDimension = product.getDimensions();
            currentVolume = currentDimension.getHeight_mm()*currentDimension.getLength_mm()*currentDimension.getWidth_mm();
            totalVolume += currentVolume;
        }
        double averageVolumeCM =  (totalVolume* 0.001) / productList.getProducts().size();
        return averageVolumeCM;
    }

    // Udskriver alle detaljer om produkterne
    public void allTogether(){
        System.out.println("Lowest price: " + this.getLowestPrice());
        System.out.println("_________________________________");
        System.out.println("Id of highest price product: " + this.findIdOfHighest());
        System.out.println("_________________________________");
        System.out.println("id's of products in stock: " + this.getIdsOfInStock());
        System.out.println("_________________________________");
        System.out.println("Average colume in cm3: "+ this.getAvgVolume());
    }
}
