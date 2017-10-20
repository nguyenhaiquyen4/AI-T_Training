package com.chapter3;

public class Main {
    public static void main(String[] args) {
        IntSequence exercise4 = IntSequence.of(3,2,1,2,34,4);
        while(exercise4.hasNext()){
            System.out.println(exercise4.next());
        }

        IntSequence exercise5 = IntSequence.constant(4);
        while (exercise5.hasNext()){
            System.out.println(exercise5.next());
        }
    }
}
