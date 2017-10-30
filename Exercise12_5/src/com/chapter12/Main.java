package com.chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    private static final int YEAR = 2013;
    private static final int MONTH = 9;
    private static final int DAY = 1;

    public static void main(String... args) {
        LocalDate birthDay = LocalDate.of(YEAR, MONTH, DAY);
        LocalDate today = LocalDate.now();
        System.out.println(birthDay);
        System.out.println(today);
        System.out.println("You have been alive for " + ChronoUnit.DAYS.between(birthDay, today) + " days");
    }
}
