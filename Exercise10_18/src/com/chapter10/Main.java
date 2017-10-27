package com.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    private static final String PATH = "..";

    private static LongAdder count = new LongAdder();
    private static long total = 0;

    public static void main(String... args) {
        try {
            List<Callable<Long>> tasks = new ArrayList<>();
            Files.walk(Paths.get(PATH)).forEach(path -> {
                if (Files.isRegularFile(path)) {
                    tasks.add(() -> {
                        try {
                            String contents = new String(Files.readAllBytes(path));
                            long c = contents.split("\\PL+").length;
                            count.add(c);
                            System.out.println(path + " : " + c);
                            return c;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        return 0L;
                    });
                }
            });
            ExecutorService service = Executors.newFixedThreadPool(4);
            List<Future<Long>> ret = service.invokeAll(tasks);

            for (Future<Long> f : ret) {
                total += f.get();
            }
            System.out.println("Total:" + total);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
        System.out.println("count = " + count);
    }
}