package com.chapter8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("text.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> result = new HashSet<>();
        Pattern.compile("\\PL+").splitAsStream(contents).distinct().forEach(result::add);

        Set<String> resultparallel = new HashSet<>();
        Pattern.compile("\\PL+").splitAsStream(contents).parallel().distinct().forEach(resultparallel::add);

        if (result.equals(resultparallel)) {
            System.out.println("Yes, can");
        }
        else {
            System.out.println("No, can't");
        }
    }
}   // Yes, it can work !
