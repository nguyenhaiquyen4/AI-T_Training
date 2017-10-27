package com.chapter10;

import java.util.*;
import java.util.concurrent.atomic.LongAccumulator;

public class Main {
    public static void main(String... args) {
        Integer[] values = new Integer[10];
        Random ran = new Random();
        Arrays.parallelSetAll(values, i -> ran.nextInt(100));
        for (Integer value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
        Set<Integer> mySet = new HashSet<>(Arrays.asList(values));
        LongAccumulator accumulator = new LongAccumulator(Long::max, 0);
        mySet.parallelStream().forEach(accumulator::accumulate);
        System.out.println("Max = " + accumulator.get());
    }
}
