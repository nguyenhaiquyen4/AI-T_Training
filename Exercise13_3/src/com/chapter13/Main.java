package com.chapter13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String... args) {
        Locale us = Locale.US;
        String usPattern = getPattern(us);
        System.out.println("US : " + usPattern);
        System.out.println("Locales math us date convention month > day > year :");
        Locale[] list = Locale.getAvailableLocales();
        for (Locale i : list) {
            if (matchUSConvention(i)) {
                print(i);
            }
        }
    }

    public static String getPattern(Locale locale) {
        return ((SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT, locale)).toPattern();
    }

    public static boolean matchUSConvention(Locale locale) {
        Pattern usForm = Pattern.compile("^M+.+d+.+y+$");
        String str = getPattern(locale);
        Matcher matcher = usForm.matcher(str);
        return matcher.matches();
    }

    private static void print(Locale locale) {
        System.out.println(
                locale.getDisplayName() + ":" + getPattern(locale));
    }
}

//        Spanish (Panama):MM/dd/yy
//        Spanish (Puerto Rico):MM-dd-yy
//        English (United States):M/d/yy
//        Spanish (El Salvador):MM-dd-yy
//        Spanish (United States):M/d/yy
//        English:M/d/yy
//        English (Philippines):M/d/yy
//        Spanish (Honduras):MM-dd-yy
//        Hindi:M/d/yy
//        Spanish (Nicaragua):MM-dd-yy