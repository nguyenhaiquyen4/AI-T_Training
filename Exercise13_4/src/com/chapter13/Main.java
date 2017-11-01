package com.chapter13;

import java.util.*;

public class Main {
    public static void main(String... args) {
        Locale[] list = Locale.getAvailableLocales();
        Map<String, Locale> mapLocale = new HashMap<>();
        for (Locale i : list) {
            if (!mapLocale.keySet().contains(i.getLanguage())) {
                mapLocale.put(i.getLanguage(), i);
            }
        }
        for (Map.Entry<String, Locale> e : mapLocale.entrySet()) {
            print(e.getValue());
        }
    }

    private static void print(Locale locale) {
        System.out.println(
                locale.getDisplayLanguage() + " : " +
                        locale.getLanguage());
    }
}

//        Hindi : hi
//        German : de
//        Norwegian : no
//        Finnish : fi
//        Belarusian : be
//        Russian : ru
//        Portuguese : pt
//        Bulgarian : bg
//        Lithuanian : lt
//        Croatian : hr
//        Latvian : lv
//        French : fr
//        Hungarian : hu
//        Ukrainian : uk
//        Slovak : sk
//        Slovenian : sl
//        Irish : ga
//        Catalan : ca
//        Albanian : sq
//        Macedonian : mk
//        Serbian : sr
//        Swedish : sv
//        Korean : ko
//        Indonesian : in
//        Malay : ms
//        Maltese : mt
//        Greek : el
//        English : en
//        Icelandic : is
//        Italian : it
//        Spanish : es
//        Chinese : zh
//        Hebrew : iw
//        Estonian : et
//        Czech : cs
//        Arabic : ar
//        Vietnamese : vi
//        Thai : th
//        Japanese : ja
//        Polish : pl
//        Danish : da
//        Romanian : ro
//        Turkish : tr
//        Dutch : nl