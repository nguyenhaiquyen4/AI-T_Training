package com.chapter8;

import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        Stream<Long> longStream = genInfiniteStreamLong(
                0L,
                25214903917L,
                11L,
                Double.doubleToLongBits(Math.pow(2, 48)));
        longStream.forEach(System.out::println);
    }

    private static Stream<Long> genInfiniteStreamLong(Long seed, Long a, Long c, Long m) {
        return Stream.iterate(seed, x->(a*x+c)%m);
    }
}
