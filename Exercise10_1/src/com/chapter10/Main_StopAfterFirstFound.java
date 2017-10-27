package com.chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Main_StopAfterFirstFound {
    private static final String PATH = "..";
    private static final String WORD = "Main";

    public static void main(String... args) {
        try {
            Set<Path> files = Files.walk(Paths.get(PATH)).collect(Collectors.toSet());
            List<Callable<Path>> tasks = new ArrayList<>();
            for (Path p : files) {
                tasks.add(() -> {
                    System.out.println("Finding in :" + p);
                    if (Files.isRegularFile(p)) {
                        String contents = new String(Files.readAllBytes(p));
                        if (contents.contains(WORD))
                            return p;
                    }
                    throw new Exception("Not found in :"+p);
                });
            }
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            System.out.println("Found in :" + executorService.invokeAny(tasks));
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
