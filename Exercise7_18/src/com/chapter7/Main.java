package com.chapter7;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String... args) {
        @SuppressWarnings("unchecked")
        List<String> a = Collections.EMPTY_LIST;
        List<String> b = Collections.emptyList();
        a.forEach(System.out::println);
        b.forEach(System.out::println);
        @SuppressWarnings("unchecked")
        Map<String,Integer> mapmm = Collections.EMPTY_MAP;
        Map<String,Integer> mapmm1 = Collections.emptyMap();
        mapmm.entrySet().forEach(System.out::println);
        mapmm1.entrySet().forEach(System.out::println);
    }

    // emptyList, emptyMap, emptySet:
    // + modern style,
    // + no warning,
    // + have generic
}
