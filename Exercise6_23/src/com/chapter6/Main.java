package com.chapter6;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String... args) {
        System.out.println(readAll(Paths.get("src/com/chapter6/Main.java")));
    }

    public static String readAll(Path path) {
        return Exceptions.doWork(() -> new String(Files.readAllBytes(path)));
    }

//    Exception in thread "main" java.lang.ClassCastException:
//        java.nio.file.NoSuchFileException cannot be cast to java.lang.RuntimeException
}
