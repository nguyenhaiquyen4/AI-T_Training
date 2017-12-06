package com.packtpub.junit.recap;

public class Resource {
    public void open() {
        System.out.println("Opened");
    }

    public void close() {
        System.out.println("Closed");
    }

    public double get() {
        return Math.random();
    }
}
