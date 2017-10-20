package com.chapter5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

enum MyError {
    SUCCESS, NOSUCHFILE, IO, NUMBERFORMAT;
}
public class Main {
    public MyError myError = MyError.SUCCESS;
    public ArrayList<Double> readValues(String filename) {
        ArrayList<Double> ret = new ArrayList<Double>(10);
        try (
            Scanner in = new Scanner(Paths.get(filename))) {
            while (in.hasNext()) {
                ret.add(Double.parseDouble(in.next()));
            }
        }
        catch (NoSuchFileException fnfex) {
            myError = MyError.NOSUCHFILE;
        }
        catch (IOException ioex) {
            myError = MyError.IO;
        }
        catch (NumberFormatException nfex) {
            myError = MyError.NUMBERFORMAT;
        }
        return ret;
    }

    public double sumOfValues(String filename) {
        double sum = 0;
        for (Double d :readValues(filename)) {
            sum += d;
        }
        return sum;
    }

    public static void main(String... args) {
        Main m = new Main();
            for (Double d : m.readValues("good.txt")) {
//            for (Double d : m.readValues("bad.txt")) {
//            for (Double d : m.readValues("notfound.txt")) {
                System.out.println(d);
            }

            System.out.println(m.sumOfValues("good.txt"));
//            System.out.println(m.sumOfValues("bad.txt"));
//            System.out.println(m.sumOfValues("notfound.txt"));
        System.out.println("ErrorCode: " + m.myError.name());
    }
}
