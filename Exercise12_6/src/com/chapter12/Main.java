package com.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

public class Main {
    public static void main(String... args) {
        TemporalAdjuster Friday13 = temporal -> {
            LocalDate date = LocalDate.from(temporal);
            date = date.plusDays(1);
            while (date.getDayOfWeek() != DayOfWeek.FRIDAY || date.getDayOfMonth() != 13) date = date.plusDays(1);
            return temporal.with(date);
        };
        LocalDate d = LocalDate.of(1901, 1, 1);
        d = d.with(Friday13);
        while (d.getYear() <= 2000) {
            System.out.println(d);
            d = d.with(Friday13);
        }
    }
}
