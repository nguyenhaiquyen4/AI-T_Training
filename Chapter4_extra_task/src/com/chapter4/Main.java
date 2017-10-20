package com.chapter4;

public class Main {
    public static void main(String... args) {
        Message m1 = new Message("message1");
        Message m2 = null;
        try {
            m2 = m1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(m1.sender);
        System.out.println(m2.sender);
    }
}
