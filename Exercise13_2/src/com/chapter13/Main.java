package com.chapter13;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String... args) {
        Locale[] list = Locale.getAvailableLocales();
        for (Locale i : list) {
            print(i);
        }
    }

    private static void print(Locale locale) {
        FormatStyle style = FormatStyle.FULL;
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(style).withLocale(locale).withDecimalStyle(DecimalStyle.of(locale));
        ZonedDateTime now = ZonedDateTime.now();
        if (!"".equals(locale.getVariant()))
            System.out.println(
                    locale.getDisplayName() + " : " +
                            locale.getDisplayLanguage() + " : " +
                            locale.getDisplayCountry() + " : " +
                            formatter.format(now));
    }
}
//Only Thai (Thailand,TH) not use Western digits
