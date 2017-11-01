package com.chapter13;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    private static ResourceBundle bundle = null;

    public static void main(String... args) {
        bundle = ResourceBundle.getBundle("bundle", Locale.forLanguageTag("vi-VN"));
        print("hello");
        print("bye");
        print("welcome");

        bundle = ResourceBundle.getBundle("bundle", Locale.forLanguageTag("fr-FR"));
        print("hello");
        print("bye");
        print("welcome");
    }

    private static void print(String str){
        System.out.println(bundle.getString(str));
    }
}
