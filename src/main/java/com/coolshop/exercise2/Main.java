package com.coolshop.exercise2;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        
        ZonedDateTime order1 = ZonedDateTime.of(2021, 5, 20, 12, 51, 32, 199883, ZoneOffset.UTC);
        ZonedDateTime order2 = ZonedDateTime.of(2021, 5, 20, 13, 3, 31, 245381, ZoneOffset.UTC);
        ZonedDateTime order3 = ZonedDateTime.of(2020, 12, 29, 12, 15, 12, 0, ZoneOffset.UTC);
        ZonedDateTime order4 = ZonedDateTime.of(2020, 12, 29, 14, 15, 12, 0, ZoneOffset.UTC);
        ZonedDateTime order5 = ZonedDateTime.of(2025, 4, 17, 15, 15, 12, 0, ZoneOffset.UTC);
        
        DeliveryCalculator deliveryOrder1 = new DeliveryCalculator(order1);
        System.out.println("Delivery Date: " + deliveryOrder1.getDeliveryDate()); //Delivery Date: 2021-05-21
        DeliveryCalculator deliveryOrder2 = new DeliveryCalculator(order2);
        System.out.println("Delivery Date: " + deliveryOrder2.getDeliveryDate()); //Delivery Date: 2021-05-25
        DeliveryCalculator deliveryOrder3 = new DeliveryCalculator(order3);
        System.out.println("Delivery Date: " + deliveryOrder3.getDeliveryDate()); //Delivery Date: 2020-12-30
        DeliveryCalculator deliveryOrder4 = new DeliveryCalculator(order4);
        System.out.println("Delivery Date: " + deliveryOrder4.getDeliveryDate()); //Delivery Date: 2021-01-04
        DeliveryCalculator deliveryOrder5 = new DeliveryCalculator(order5);
        System.out.println("Delivery Date: " + deliveryOrder5.getDeliveryDate()); //Delivery Date: 2025-04-22
    }
}