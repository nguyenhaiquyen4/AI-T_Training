package com.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.*;

public class Main {
    final static String FILENAME = "src/com/test/Main.java";

    public static void main(String... args) throws IOException {
        List<String> lines = readAllLines(Paths.get(FILENAME));

        Optional<String> max = lines.stream().max(Comparator.comparing(String::length));
        System.out.println(max.get());
    }
}
