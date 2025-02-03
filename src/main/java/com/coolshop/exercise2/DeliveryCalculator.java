package com.coolshop.exercise2;
import java.time.*;
import java.util.*;

class DeliveryCalculator{
    // Tidszone for Danmark
    private final ZoneId danishTime = ZoneId.of("Europe/Copenhagen");
    // cutoff for ordrer (kl. 15:00)
    private final LocalTime cutOff = LocalTime.of(15, 0, 0);
    // Oprindelig ordre tid i UTC
    private final  ZonedDateTime orderTimeUtc;
     // Ordre tid konverteret til dansk tid
    private final ZonedDateTime orderTimeDenmark;
    // Dato og tid for ordren i Danmark
    private final LocalDate orderDate;
    private final LocalTime orderTime;
    private final int orderYear;
    // Liste over helligdage
    private final Set<MonthDay> Holidays = new HashSet<>();

    public DeliveryCalculator(ZonedDateTime orderTimeUtc){
        // Får værdier vha constructor
        this.orderTimeUtc = orderTimeUtc;
        this.orderTimeDenmark = orderTimeUtc.withZoneSameInstant(danishTime);
        this.orderDate = orderTimeDenmark.toLocalDate();
        this.orderTime = orderTimeDenmark.toLocalTime();
        this.orderYear = orderTimeDenmark.getYear();
        
        //Beregner dynamiske helligdage for det givne år
        LocalDate easter = EasterDay(orderYear);
        LocalDate longFriday = LongFridayEaster(orderYear);
        LocalDate secondEaster = SecondEasterDay(orderYear);
        LocalDate skaerTorsdag = SkaerTorsdag(orderYear);
        LocalDate palmSunday = PalmSunday(orderYear);
        LocalDate kristiHimmelFartsDag = KristiHimmelFartsDag(orderYear);   
        LocalDate pinse = Pinse(orderYear);
        LocalDate secondPinse = SecondPinse(orderYear);

        // Tilføjer faste helligdage
        Holidays.add(MonthDay.of(1, 1)); //Nytår
        Holidays.add(MonthDay.of(6, 5));  //Constitution
        Holidays.add(MonthDay.of(12, 31)); //Nytår
        Holidays.add(MonthDay.of(12, 24)); //Jul
        Holidays.add(MonthDay.of(12, 25)); //FørsteJuledag
        Holidays.add(MonthDay.of(12, 26)); //Anden juledag

        // Tilføjer de dynamiske helligdage 
        Holidays.add(MonthDay.from(easter));
        Holidays.add(MonthDay.from(longFriday));
        Holidays.add(MonthDay.from(secondEaster));
        Holidays.add(MonthDay.from(skaerTorsdag));
        Holidays.add(MonthDay.from(palmSunday));
        Holidays.add(MonthDay.from(kristiHimmelFartsDag));
        Holidays.add(MonthDay.from(pinse));
        Holidays.add(MonthDay.from(secondPinse));
    }
    
    // Beregner leveringsdato baseret på ordrens tidspunkt
    public LocalDate getDeliveryDate(){
                
        LocalDate deliveryDate;
        // Hvis leveringsdatoen falder på en hverdag og før kl 15, leveringtid + 1
        if (isWorkDay(orderDate) && orderTime.isBefore(cutOff)) {
            deliveryDate = orderDate.plusDays(1); 
        }else {
            deliveryDate = orderDate.plusDays(2); 
        }
        // hvis den nuværende estimeret leveringstid ikke er workday, skal der incrementes indtil det er workday
        while (!isWorkDay(deliveryDate)) {
            deliveryDate = deliveryDate.plusDays(1);
        }
        return deliveryDate;
    }
    
    private boolean isWorkDay(LocalDate date) {  
            return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || Holidays.contains(MonthDay.from(date)));
    }
    
    //Beregner hvornår påskedag falder baseret på en algoritme fra nettet
    public LocalDate EasterDay(int year){
        LocalDate EasterDay;
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (13 + 8 * k)/ 25;
        int q = k/4;
        int m = (15-p+k-q) % 30;
        int n = (4+k-q) % 7;
        int d = (19*a + m) % 30;
        int e = (2* b + 4* c + 6*d + n ) % 7;

        if(22+d+e>31)
        {
            EasterDay = LocalDate.of(year, 4,d+e-9);
        }
        else
        {
            EasterDay = LocalDate.of(year, 3, 22+d+e);
        }

        if(d == e && e == 6)
        {
            EasterDay = LocalDate.of(year, 4, 19);
        }
        if(d == 28 && e == 6 && a>10)
        {
            EasterDay = LocalDate.of(year, 4, 18);
        }
        return EasterDay;

    }

    // Beregner langfredag (fredagen før påskedag)
    public LocalDate LongFridayEaster(int year){
        return EasterDay(year).minusDays(2);
    }
    // Beregner anden påskedag (dagen efter påskedag)
    public LocalDate SecondEasterDay(int year){
        return EasterDay(year).plusDays(1);
    }
    // Beregner skærtorsdag (dagen før langfredag)
    public LocalDate SkaerTorsdag(int year){
        return LongFridayEaster(year).minusDays(1);
    }
    // Beregner palmesøndag (søndagen før påske)
    public LocalDate PalmSunday(int year){
        return SkaerTorsdag(year).minusDays(4);
    }
    // Beregner Kristi Himmelfartsdag (39 dage efter påske)
    public LocalDate KristiHimmelFartsDag(int year){
        return EasterDay(year).plusDays(39);
    }
    // Beregner pinsedag (10 dage efter Kristi Himmelfartsdag)
    public LocalDate Pinse(int year){
        return KristiHimmelFartsDag(year).plusDays(10);
    }
    // Beregner anden pinsedag (dagen efter pinsedag)
    public LocalDate SecondPinse(int year){
        return Pinse(year).plusDays(1);
    }
}


