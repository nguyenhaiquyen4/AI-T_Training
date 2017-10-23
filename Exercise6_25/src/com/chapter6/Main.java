package com.chapter6;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Objects;

public class Main {
    public static void main(String... args) throws Exception{
//        genericDeclaration(Class.forName("java.lang.System").getField("out").getType().getMethod("println", String.class));
//        genericDeclaration(Class.forName("com.chapter6.Test").getMethod("test", String.class));
        genericDeclaration(Class.forName("com.chapter6.Arrays").getMethods()[4]);

        Class<?> cc = Class.forName("com.chapter6.Arrays");
    }


    public static String genericDeclaration(Method m) {
        System.out.println("Method name: " + m.getName());
        System.out.println("Return type: " + m.getReturnType().getName());
        System.out.println("Return type: " + m.getGenericReturnType().getTypeName());
        for (TypeVariable<Method> type : m.getTypeParameters()) {
            System.out.println("Type parameters name: " + type.getTypeName());
            for (Type typebound : type.getBounds()) {
                System.out.println("Type parameters bounds: " + typebound.getTypeName());
            }
        }
        for (Class type : m.getParameterTypes()) {
            System.out.println("Parameter types: " + type.getTypeName());
            for (TypeVariable<Class> typeclass : type.getTypeParameters()) {
                System.out.println("Parameter types class:" + typeclass.getName());
            }
        }
        return "";
    }
}
