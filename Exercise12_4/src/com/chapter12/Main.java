package com.chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    private static final int MONTH = 10;
    private static final int YEAR = 2017;

    public static void main(String... args) {
        LocalDate d = LocalDate.of(YEAR, MONTH, 1);
        System.out.println(" Su Mo Tu We Th Fr Sa");
        for (int i = 0; i < d.getDayOfWeek().getValue() % 7; i++)
            System.out.print("   ");
        while (d.getMonthValue() == MONTH) {
            System.out.printf("%3d", d.getDayOfMonth());
            if (d.getDayOfWeek() == DayOfWeek.SATURDAY)
                System.out.println();
            d = d.plusDays(1);
        }
    }
}
