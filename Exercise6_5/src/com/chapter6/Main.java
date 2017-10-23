package com.chapter6;

public class Main {
    public static void main(String... args) {
        Double[] result = Arrays.<Double>swap(0, 1 , 1.5, 2.0, 3.0);
        // The error message is improved
        // To solve the problem, cast values parameter to double
    }
}
