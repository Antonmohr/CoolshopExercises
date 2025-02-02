package com.coolshop.exercise2;
import java.time.*;
import java.util.*;

 class DeliveryCalculator{
    private final ZoneId danishTime = ZoneId.of("Europe/Copenhagen");
    private static final LocalTime cutOff = LocalTime.of(15, 0, 0);

    
    private static final Set<MonthDay> Holidays = new HashSet<>();
    static {
        Holidays.add(MonthDay.of(1,1));
        Holidays.add(MonthDay.of(6,5));
        Holidays.add(MonthDay.of(12, 31));
         
    }

    public LocalDate getDeliveryDate(ZonedDateTime orderTimeUtc){
        ZonedDateTime orderTimeDenmark = orderTimeUtc.withZoneSameInstant(danishTime);
        LocalDate orderDate = orderTimeDenmark.toLocalDate();
        LocalTime orderTime = orderTimeDenmark.toLocalTime();

        LocalDate deliveryDate;
        if (isWorkDay(orderDate) && orderTime.isBefore(cutOff)) {
            deliveryDate = orderDate.plusDays(1); 
        } else {
            deliveryDate = orderDate.plusDays(2); 
        }

        
        while (!isWorkDay(deliveryDate)) {
            deliveryDate = deliveryDate.plusDays(1);
        }

        return deliveryDate;
    }
    private static boolean isWorkDay(LocalDate date) {
        
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || Holidays.contains(MonthDay.from(date)));
    }

}
