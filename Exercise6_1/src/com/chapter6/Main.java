package com.chapter6;

public class Main {
    public static void main(String... args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push("mot");
        stack.push("hai");
        System.out.println(stack.pop());
        stack.push("ba");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
