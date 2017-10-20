package com.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void maina(String... args)
    {
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Paths.get("aaa.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception ex) {

                }

            }
        }
    }

    public static void main(String... args) throws Throwable // Don't know
    {
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Paths.get("aaa.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            throw new Exception("aaa123");
        }
        catch (Exception ex) {
            Throwable aaa = new Throwable("xyz");

            aaa.initCause(ex);
            aaa.getStackTrace();
            System.err.println("Caught IOException: " + ex.getMessage());
            throw aaa;
        }
    }

    public static void mainc(String... args)
    {
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get("aaa.txt"))
                ){
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
