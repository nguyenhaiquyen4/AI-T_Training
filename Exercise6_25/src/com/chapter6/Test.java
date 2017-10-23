package com.chapter6;

import java.util.ArrayList;

public class Test {
    public boolean test(Boolean b) {
        return !b;
    }

    public String test(String str) {
        return str + " hello";
    }

    @SafeVarargs
    public static <T> ArrayList<T> asList(T... elements) {
        ArrayList<T> res = new ArrayList<>(10);
        for (T e : elements) {
            res.add(e);
        }
        return res;
    }
}
