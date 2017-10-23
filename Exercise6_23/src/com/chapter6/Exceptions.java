package com.chapter6;

import java.util.concurrent.Callable;

public class Exceptions {
    private static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T)e;
    }

    public static <V> V doWork(Callable<V> c) {
        try {
            return c.call();
        }
        catch (Throwable ex) {
            System.out.println("xxxxxx");
//            Exceptions.<RuntimeException>throwAs(ex);
            throw (RuntimeException)ex;
//            return null;
        }
    }
}