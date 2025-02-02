package com.coolshop.exercise2;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        
        ZonedDateTime order1 = ZonedDateTime.of(2021, 5, 20, 16, 51, 32, 199883, ZoneOffset.UTC);
        ZonedDateTime order2 = ZonedDateTime.of(2021, 5, 20, 13, 3, 31, 245381, ZoneOffset.UTC);
        ZonedDateTime order3 = ZonedDateTime.of(2020, 12, 31, 12, 15, 12, 0, ZoneOffset.UTC);
        ZonedDateTime order4 = ZonedDateTime.of(2025, 2, 1, 16, 15, 12, 0, ZoneOffset.UTC);
        
        DeliveryCalculator cal = new DeliveryCalculator();
        System.out.println(cal.getDeliveryDate(order1)); 
        System.out.println(cal.getDeliveryDate(order2)); 
        System.out.println(cal.getDeliveryDate(order3)); 
        System.out.println(cal.getDeliveryDate(order4));
        
        
    }
}