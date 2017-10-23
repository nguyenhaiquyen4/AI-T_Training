package com.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> strs = new ArrayList<String>(10);
        List<String> strsminmax = new ArrayList<String>(3);
        strs.add("mothaiba");
        strs.add("123");
        strs.add("abcd");
        minmax(strs, (x,y) -> x.length()-y.length(), strsminmax);
        strsminmax.forEach(x -> System.out.println(x));
    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        if (elements.isEmpty()) return;
        Object min, max;
        min = max = elements.get(0);
        for (T i : elements) {
            if (comp.compare((T)min, i) > 0) {
                min = i;
            }
            if (comp.compare((T)max, i) < 0) {
                max = i;
            }
        }
        result.add((T)min);
        result.add((T)max);
    }
}
