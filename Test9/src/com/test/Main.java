package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String... args) {
        LongAdder longAdder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Long>> tasks = new ArrayList<>();
        tasks.add(() -> {
            for (int i = 1; i <= 1000; i++)
                longAdder.increment();
            return longAdder.longValue();
        });

        tasks.add(() -> {
            for (int i = 1; i <= 1000; i++)
                longAdder.increment();
            return longAdder.longValue();
        });

        try {
            executor.invokeAll(tasks);
            System.out.println("Finish : " + longAdder.longValue());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
