package com.chapter12;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class Main {
    public static void main(String... args) {
        ZoneId.getAvailableZoneIds().parallelStream().forEach(x -> {
            TimeZone tz = TimeZone.getTimeZone(x);
            if (tz.getRawOffset() / 1000 / 60 % 60 > 0) {
                System.out.print(x + " : " + tz.getDisplayName() + " : ");
                System.out.println(tz.getRawOffset() / 1000 / 60 / 60.0);
            }
        });
    }
}