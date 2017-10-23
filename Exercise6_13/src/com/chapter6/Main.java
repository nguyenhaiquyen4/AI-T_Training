package com.chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> strs = new ArrayList<>(10);
        List<String> strsminmax = new ArrayList<>(3);
        strs.add("mothaiba");
        strs.add("123");
        strs.add("abcd");
        minmax(strs, Comparator.comparing(String::length), strsminmax);
        strsminmax.forEach(System.out::println);

        List<String> strsmaxmin = new ArrayList<>(3);
        maxmin(strs, Comparator.comparing(String::length) , strsmaxmin);
        strsmaxmin.forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
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

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        Lists.swapHelper(result, 0 , 1);
    }

//    What wildcard to captured ? I don't capture anything !
//    Don't understand this question !
}
