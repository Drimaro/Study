package ru.ksilin.study.java8;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Created by konstantin.silin on 05.06.2016.
 */
public class Dates {
    public static void main(String[] args) {
        Duration minDuration = Duration.of(1, ChronoUnit.MINUTES);
        Duration secDuration = Duration.of(90, ChronoUnit.SECONDS);
        System.out.println("minute = " + minDuration + " seconds = " + secDuration);
    }
}
