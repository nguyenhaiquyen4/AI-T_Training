package com.chapter7;

public class Main {
    public static void main(String... args) {
        Cache<String,Integer> myCache = new Cache<>(3);
        myCache.put("Susan", 13);
        myCache.put("Helen", 14);
        myCache.put("Alan", 3);
        myCache.entrySet().forEach(System.out::println);
        myCache.put("Alan", 5);
        myCache.entrySet().forEach(System.out::println);
        myCache.put("Ken", 7);
        myCache.entrySet().forEach(System.out::println);
    }
}
