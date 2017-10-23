package com.chapter6;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> array;
    public Stack() {
        array = new ArrayList<>(10);
    }

    public void push(E e) {
        array.add(e);
    }

    public E pop() {
        return array.remove(array.size()-1);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
