package com.chapter3;

public class Main {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.randomInts(10, 30);
        while (seq.hasNext()) {
            System.out.println(seq.next());
        }
    }
}
