package com.chapter13;

import java.util.*;

public class Main {
    public static void main(String... args) {
        Locale[] list = Locale.getAvailableLocales();
        Map<String, Set<Locale>> mapLocale = new HashMap<>();
        for (Locale i : list) {
            try {
                String currencyCode = Currency.getInstance(i).getCurrencyCode();
                if (!mapLocale.keySet().contains(currencyCode)) {
                    Set<Locale> values = new HashSet<>();
                    values.add(i);
                    mapLocale.put(currencyCode, values);
                } else {
                    mapLocale.get(currencyCode).add(i);
                }
            } catch (IllegalArgumentException ex) {
//                ex.printStackTrace();
            }
        }
        for (Map.Entry<String, Set<Locale>> e : mapLocale.entrySet()) {
            if (e.getValue().size()>=2)
            print(e);
        }
    }

    private static void print(Map.Entry<String, Set<Locale>> m) {
        System.out.print(m.getKey() + " : ");
        m.getValue().forEach(x -> System.out.print(x.getDisplayCountry() + " "));
        System.out.println();
    }
}
//Note that this program list currency by LOCALE (NOT BY COUNTRY)
//
//        CHF : Switzerland Switzerland Switzerland
//        RSD : Serbia Serbia
//        EUR : Cyprus Belgium Netherlands Latvia Luxembourg Malta Germany Ireland Spain Estonia Slovakia Lithuania Italy Portugal Luxembourg Ireland Belgium Montenegro Spain Greece Greece Malta Finland Slovenia France Austria Montenegro
//        CAD : Canada Canada
//        NOK : Norway Norway
//        INR : India India
//        THB : Thailand Thailand
//        JPY : Japan Japan
//        USD : Ecuador United States Puerto Rico United States
//        BAM : Bosnia and Herzegovina Bosnia and Herzegovina
//        SGD : Singapore Singapore