package com.chapter11;

import java.lang.reflect.Field;

public class Cloneables {
    public static Object clone(Object obj) throws CloneNotSupportedException, IllegalAccessException, InstantiationException {
        if (obj==null) return null;
        Class<?> cl = obj.getClass();
        Cloneable clone = cl.getAnnotation(Cloneable.class);
        if (clone==null) {
            throw new CloneNotSupportedException("No Cloneable Annotation");
        }
        Object ret = cl.newInstance();
        for (Field f : cl.getDeclaredFields()) {
            f.setAccessible(true);
            f.set(ret, f.get(obj));
        }
        return ret;
    }
}
