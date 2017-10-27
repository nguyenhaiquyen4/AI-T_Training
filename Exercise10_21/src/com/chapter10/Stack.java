package com.chapter10;

public class Stack {
    private Object myLock = "LOCK"; // private ! Why need lock ?

    public void push(Object newValue) {
        synchronized (myLock) {

        }
    }
}
