package com.chapter5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Double> readValues(String filename) throws IOException, NoSuchFileException, NumberFormatException {
        ArrayList<Double> ret = new ArrayList<Double>(100);
        try (
            Scanner in = new Scanner(Paths.get(filename))) {
            while (in.hasNext()) {
                ret.add(Double.parseDouble(in.next()));
            }
        }
        catch (NoSuchFileException fnfex) {
            System.out.println("NoSuchFileException: " + fnfex.getMessage());
            throw fnfex;
        }
        catch (IOException ioex) {
            System.out.println("IOException: " + ioex.getMessage());
            throw ioex;
        }
        catch (NumberFormatException nfex) {
            System.out.println("NumberFormatException: " + nfex.getMessage());
            throw nfex;
        }
        return ret;
    }

    public double sumOfValues(String filename) throws IOException, NoSuchFileException, NumberFormatException {
        double sum = 0;
        for (Double d :readValues(filename)) {
            sum += d;
        }
        return sum;
    }

    public static void main(String... args) {
        Main m = new Main();
        try {
            for (Double d : m.readValues("good.txt")) {
//            for (Double d : m.readValues("bad.txt")) {
//            for (Double d : m.readValues("notfound.txt")) {
                System.out.println(d);
            }

            System.out.println(m.sumOfValues("good.txt"));
//            System.out.println(m.sumOfValues("bad.txt"));
            System.out.println(m.sumOfValues("notfound.txt"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
