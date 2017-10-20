package com.chapter5;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        method1();
    }

    public static void method1(){
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("/usr/share/dict/words"));
            out = new PrintWriter("output.txt");
            while (in.hasNext()) {
                out.println(in.next().toUpperCase());
            }
            out.close();
            in.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            if (out != null)
                out.close();
            if (in != null)
                in.close();
        }
    }
}
