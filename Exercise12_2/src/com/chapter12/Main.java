package com.chapter12;

import java.time.LocalDate;

public class Main {
    public static void main(String... args) {
        LocalDate whatHappen = LocalDate.of(2000, 2,29);
        LocalDate next = whatHappen.plusYears(1);
        System.out.println(next);
    }
}
// 2001-02-28