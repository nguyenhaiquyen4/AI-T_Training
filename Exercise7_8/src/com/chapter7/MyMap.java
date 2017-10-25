package com.chapter7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyMap extends HashMap<String, Set<Integer>> {
    public void add(String word, Integer line) {
        Set<Integer> values = super.getOrDefault(word, null);
        if (values == null) {
            values = new HashSet<>();
            super.put(word, values);
        }
        values.add(line);
    }
    public void printOut() {
        super.entrySet().forEach(System.out::println);
    }
}
