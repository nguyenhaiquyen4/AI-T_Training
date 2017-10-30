package com.chapter12;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class Main {
    public static void main(String... args) {
        LocalDate today = LocalDate.of(2017, 10, 28);
        today = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println("Next working day : " + today);
    }

    private static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return temporal -> {
            LocalDate date = LocalDate.from(temporal);
            date = date.plusDays(1);
            while (!predicate.test(date)) date = date.plusDays(1);
            return temporal.with(date);
        };
    }
}
