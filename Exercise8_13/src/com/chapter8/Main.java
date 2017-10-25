package com.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {
        ArrayList<String> a1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> a2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> a3 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> a4 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> a5 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
//        ArrayList<String> c1 = joinStreamArray1(Stream.of(a1, a2, a3, a4, a5));
//        System.out.println(c1);

        ArrayList<String> c2 = joinStreamArray2(Stream.of(a1, a2, a3, a4, a5));
        System.out.println(c2);

//        ArrayList<String> c3 = joinStreamArray3(Stream.of(a1, a2, a3, a4, a5));
//        System.out.println(c3);
    }

    private static <T> ArrayList<T> joinStreamArray1(Stream<ArrayList<T>> streamArray) {
        return streamArray.reduce((x,y)->{x.addAll(y);return x;}).get();
    }

    private static <T> ArrayList<T> joinStreamArray2(Stream<ArrayList<T>> streamArray) {
        return streamArray.reduce(new ArrayList<>(), (x,y)->{x.addAll(y);return x;});
    }

    private static <T> ArrayList<T> joinStreamArray3(Stream<ArrayList<T>> streamArray) {
        return streamArray.reduce(new ArrayList<>(), (x,y)->{x.addAll(y);return x;}, (x,y)->{x.addAll(y);return x;});
    }
}
