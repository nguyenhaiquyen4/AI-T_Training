package com.chapter8;

import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        letters("Hello AIT").forEach(System.out::println);
    }

    private static Stream<String> letters(String s) {
        return s.codePoints().mapToObj((x)->Character.toString((char)x));
    }
}
