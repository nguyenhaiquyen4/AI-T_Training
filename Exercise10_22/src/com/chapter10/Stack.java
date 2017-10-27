package com.chapter10;

import java.util.concurrent.locks.ReentrantLock;

public class Stack {
    public void push(Object newValue) {
        synchronized (new ReentrantLock()) { // This lock is useless, it not lock data of stack, it lock the key !!!

        }
    }
}
