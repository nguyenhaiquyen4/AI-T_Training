package com.chapter8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        int[] values = { 1, 4, 9, 16};
        System.out.println(Stream.of(values).getClass().getName());
        Stream aaa = Stream.of(values); // This is a Stream but Stream of what? I don;t know
        aaa.forEach(System.out::println);

        IntStream a = IntStream.of(values); // <<<<<< Use IntStream
        a.forEach(System.out::println);
    }
}
