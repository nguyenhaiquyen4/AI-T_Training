package com.chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static int count = 0;
    public static void main(String... args) throws IOException{
        long start1 = System.currentTimeMillis();
        scanner();
        System.out.println(count);
        long elapsedTimeMillis1 = System.currentTimeMillis()-start1;
        float elapsedTimeSec1 = elapsedTimeMillis1/1000F;
        System.out.println(elapsedTimeSec1);

        long start2 = System.currentTimeMillis();
        bufferLines();
        System.out.println(count);
        long elapsedTimeMillis2 = System.currentTimeMillis()-start2;
        float elapsedTimeSec2 = elapsedTimeMillis2/1000F;
        System.out.println(elapsedTimeSec2);

        long start3 = System.currentTimeMillis();
        bufferStream();
        System.out.println(count);
        long elapsedTimeMillis3 = System.currentTimeMillis()-start3;
        float elapsedTimeSec3 = elapsedTimeMillis3/1000F;
        System.out.println(elapsedTimeSec3);
    }
    private static void scanner() throws IOException{
        Scanner scanner = new Scanner(Paths.get("src/com/chapter9/Main.java"));
        count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count(null);
        }
        scanner.close();
    }

    private static void bufferLines() throws IOException{   // THE BEST MOST CONVENIENT
        BufferedReader buf = Files.newBufferedReader(Paths.get("src/com/chapter9/Main.java"));
        count = 0;
        while(buf.readLine()!=null) count(null);
        buf.close();
    }

    private static void bufferStream() throws IOException{
        BufferedReader buf = Files.newBufferedReader(Paths.get("src/com/chapter9/Main.java"));
        count = 0;
        buf.lines().forEach(Main::count);
        buf.close();
    }

    public static void count(Object x) {
        count++;
    }
}
