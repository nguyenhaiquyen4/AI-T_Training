package com.test;

import javax.swing.text.DateFormatter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String... args) {
        print(Locale.JAPAN);
        print(Locale.ENGLISH);
    }

    private static void print(Locale locale) {
        FormatStyle style = FormatStyle.FULL;
        DateTimeFormatter formatter = DateTimeFormatter.
                ofLocalizedDateTime(style).withLocale(locale).withDecimalStyle(DecimalStyle.of(locale));
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(
                locale.getDisplayLanguage() + " : " +
                        locale.getDisplayCountry() + " : " +
                        formatter.format(now));
    }
}
