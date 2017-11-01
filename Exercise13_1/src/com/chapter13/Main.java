package com.chapter13;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String... args) {
        Locale france = Locale.FRANCE;  //mercredi 1 novembre 2017 08 h 52 ICT
        Locale china = Locale.CHINA;    //2017年11月1日 星期三 上午08时53分07秒 ICT
        Locale thailand = new Locale("th", "TH", "TH"); //Thai : Thailand : วันพุธที่ ๑ พฤศจิกายน ค.ศ. ๒๐๑๗, ๙ นาฬิกา ๓๑ นาที ๓๗ วินาที

        print(france);
        print(china);
        print(thailand);
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
