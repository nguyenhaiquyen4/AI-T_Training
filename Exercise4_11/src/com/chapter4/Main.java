package com.chapter4;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {
    public static void main(String... args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            Class<?> class1 = Class.forName("java.lang.System");
            Field field = class1.getField("out");
            Method method = field.getType().getMethod("println", String.class);
            method.invoke(field.get(null), "Hello, AI&T");
        }
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            System.out.println("Hello, AI&T");
        }
        long elapsedTimeMillis1 = System.currentTimeMillis()-start1;
        float elapsedTimeSec1 = elapsedTimeMillis1/1000F;

        System.out.println(elapsedTimeSec+ " VS " + elapsedTimeSec1);
    }
}
