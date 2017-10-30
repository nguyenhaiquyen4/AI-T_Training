package com.chapter12;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    private static final int YEAR = 2017;

    public static void main(String... args) {
        Locale vn = new Locale("vi", "VN");
        LocalDate fDay = LocalDate.of(YEAR, 1, 1);
        LocalDate programmerDay = fDay.plus(Period.ofDays(256));
        DateTimeFormatter vnFormatter = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        System.out.println("Programmer Day " + programmerDay.getYear() + " : " + programmerDay.format(vnFormatter.withLocale(vn)));
    }
}
