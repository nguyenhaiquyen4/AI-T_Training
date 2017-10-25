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

        long start = System.currentTimeMillis();
        Stream<String> words1 = Pattern.compile("\\PL+").splitAsStream(contents);
        words1.filter((x)->x.length()>12).limit(5).forEach(System.out::println);

        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;

        long start1 = System.currentTimeMillis();
        Stream<String> words2 = Pattern.compile("\\PL+").splitAsStream(contents).parallel();
        words2.filter((x)->x.length()>12).limit(5).forEach(System.out::println);

        long elapsedTimeMillis1 = System.currentTimeMillis()-start1;
        float elapsedTimeSec1 = elapsedTimeMillis1/1000F;

        System.out.println(elapsedTimeSec+ " VS " + elapsedTimeSec1);
    }
    // Why the 2 lists return are same ?
    // The parallel list would return differently !!!
}
