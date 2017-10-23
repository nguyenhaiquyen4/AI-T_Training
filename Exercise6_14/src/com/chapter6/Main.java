package com.chapter6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        ArrayList<FileInputStream> array = new ArrayList<>(5);
        try {
            // How TO ????
            array.add(new FileInputStream("/usr/share/dict/words"));
            array.add(new FileInputStream("/usr/share/dict/words"));
            array.add(new FileInputStream("/usr/share/dict/words"));
            array.add(new FileInputStream("/usr/share/dict/words"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Arrays.<FileInputStream>closeAll(array);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
