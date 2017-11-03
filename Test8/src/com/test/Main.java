package com.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    final static String FILENAME = "src/com/test/Main.java";

    public static void main(String... args) throws IOException{
        String contents = new String(Files.readAllBytes( Paths.get(FILENAME)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Stream<String> stream = words.stream();
        System.out.println("Not parallel:");
        stream.filter(x->x.length()>10).forEach(System.out::println);
        Stream<String> stream2 = words.stream();
        System.out.println("Parallel:");
        stream2.parallel().filter(x->x.length()>10).forEach(System.out::println);
    }
}
