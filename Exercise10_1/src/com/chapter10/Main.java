package com.chapter10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String PATH = "..";
    private static final String WORD = "Main";

    private static volatile boolean done = false;

    public static void main(String... args) {
        try {
            Files.walk(Paths.get(PATH)).parallel().peek(System.out::println).forEach(p -> {
                if (!done) {
                    try {
                        System.out.println("Finding in :" + p);
                        if (Files.isRegularFile(p)) {

                            String contents = new String(Files.readAllBytes(p));
                            if (contents.contains(WORD)) {
                                System.out.println("Found in :" + p);
                                done = true;
                            }
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//    This is not actually find just the first one,
//    even if the first is found, the solution still browse all remain path without doing anything
}
