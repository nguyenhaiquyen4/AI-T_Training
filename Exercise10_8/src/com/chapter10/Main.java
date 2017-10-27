package com.chapter10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String... args) {
        long start1 = System.currentTimeMillis();
        increaseAtomicLong();
        long elapsedTimeMillis1 = System.currentTimeMillis() - start1;
        float elapsedTimeSec1 = elapsedTimeMillis1 / 1000F;

        long start2 = System.currentTimeMillis();
        increaseLongAdder();
        long elapsedTimeMillis2 = System.currentTimeMillis() - start2;
        float elapsedTimeSec2 = elapsedTimeMillis2 / 1000F;

        System.out.println("increaseAtomicLong" + elapsedTimeSec1);
        System.out.println("increaseLongAdder" + elapsedTimeSec2);
    }

    private static void increaseAtomicLong() {
        AtomicLong aLong = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Long>> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(() -> {
                while (aLong.get() < 100000) aLong.incrementAndGet();
                return aLong.get();
            });
        }
        try {
            System.out.println("Finish : " + executor.invokeAny(tasks));
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static void increaseLongAdder() {
        LongAdder longAdder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Long>> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(() -> {
                while (longAdder.longValue() < 100000) {
                    longAdder.increment();
                }
                return longAdder.longValue();
            });
        }
        try {
            System.out.println("Finish : " + executor.invokeAny(tasks));
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
