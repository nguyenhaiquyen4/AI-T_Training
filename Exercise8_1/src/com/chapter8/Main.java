package com.chapter8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        String contents = null;
        try {
            contents = new String(Files.readAllBytes(Paths.get("src/com/chapter8/Main.java")), StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        Stream<String> words1 = Pattern.compile("\\PL+").splitAsStream(contents);
        words1.filter((x)->{System.out.println("filter"); return x.length()>12;}).limit(5).forEach(System.out::println);
    }
    // ProgramStopHere
    // "filter" stop printed out after the 5th Long Word are list out.
}
