package com.chapter6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.IntFunction;

public class Arrays {
    public static <T> void swap(ArrayList<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        for (T elem: elems) {
            elem.close();
        }
//        elems.forEach((x) -> {
//            try {
//                x.close();
//            } catch (Exception e) {
//                throw e;
//                e.printStackTrace();
//            }
//        });
    }

    public static void printNames(ArrayList<? extends Employee> staff) {
        for (int i = 0; i<staff.size();i++) {
            Employee e = staff.get(i);
            System.out.println(e.getName());
        }
    }

    public static void printAll(Employee[] staff, Predicate<? super Employee> filter) {
        for (Employee e : staff) {
            if (filter.test(e))
                System.out.println(e.getName());
        }
    }

//    public void addAll(Collection<? extends E> c) {
//
//    }

    public static boolean hasNulls(ArrayList<?> elements) {
        for (Object o : elements) {
            if (o == null) return true;
        }
        return false;
    }

    public static <E> ArrayList<E> repeat(int n, E obj) {
        ArrayList<E> retobjs = new ArrayList<>(10);
        for (int i = 0; i < n ; i++) {
            retobjs.add(obj);
        }
        return retobjs;
    }

    @SafeVarargs
    public static <T> ArrayList<T> asList(T... elements) {
        ArrayList<T> res = new ArrayList<>(10);
        for (T e : elements) {
            res.add(e);
        }
        return res;
    }
}
