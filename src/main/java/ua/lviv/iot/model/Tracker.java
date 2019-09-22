package ua.lviv.iot.model;


import ua.lviv.iot.services.impl.BooksSortingService;

import java.time.Duration;
import java.time.LocalTime;


public class Tracker extends BooksSortingService {
    public int comparisionCount;
    public int exchangeCount;
    public LocalTime timeStart;

    public Tracker() {
        comparisionCount = 0;
        exchangeCount = 0;
        timeStart = LocalTime.now();
    }

    public void init() {
        comparisionCount = 0;
        exchangeCount = 0;
        timeStart = LocalTime.now();
    }

    public void showStats() {
        System.out.println("Executing time: " + Duration.between(timeStart, LocalTime.now()).toMillis());
        System.out.println("Comparisons: " + comparisionCount);
        System.out.println("Exchanges: " + exchangeCount);
    }
} 