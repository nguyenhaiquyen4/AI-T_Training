package com.chapter6;

import java.util.List;

public class Lists {
    public static <T> void swapHelper(List<T> elements, int a, int b) {
        T temp = elements.get(a);
        elements.set(a, elements.get(b));
        elements.set(b, temp);
    }
}
