package com.chapter12;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String... args) {
        ZonedDateTime start = ZonedDateTime.of(
                2017, 10, 1, 14, 5, 0, 0, ZoneId.of("UTC+1"));
        ZonedDateTime end = ZonedDateTime.of(
                2017, 10, 1, 16, 40, 0, 0, ZoneId.of("UTC-5"));
        System.out.println(ChronoUnit.MINUTES.between(start, end) + " minutes");
    }
}
