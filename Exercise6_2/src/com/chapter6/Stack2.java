package com.chapter6;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Stack2<E> {

    private E[] array;
    private int last;

    public Stack2(IntFunction<E[]> c) {
        array = c.apply(1);
        last = 0;
    }

    public void push(E e) {
        if (last == array.length) {
            array = Arrays.copyOf(array, array.length << 1);
        }
        array[last] = e;
        last++;
    }

    public E pop() {
        return array[--last];
    }

    public boolean isEmpty() {
        return last == 0;
    }
}
