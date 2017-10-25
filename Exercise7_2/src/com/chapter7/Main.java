package com.chapter7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String... args) {
        a(); // Not Work !!!
        b(); // Not Work !!!
        c();
    }

    public static void a() {
        List<String> strList = new ArrayList<>();
        strList.add("welcome");
        strList.add("passengers !");
        Iterator<String> iter = strList.iterator();
        iter.forEachRemaining((x)->x.toUpperCase());
        strList.forEach(System.out::println);
    }

    public static void b() {
        List<String> strList = new ArrayList<>();
        strList.add("welcome");
        strList.add("passengers !");
        for (int i =0;i<strList.size();i++) {
            strList.get(i).toUpperCase();
        }
        strList.forEach(System.out::println);
    }

    public static void c() {
        List<String> strList = new ArrayList<>();
        strList.add("welcome");
        strList.add("passengers !");
        strList.replaceAll(String::toUpperCase);
        strList.forEach(System.out::println);
    }
}
