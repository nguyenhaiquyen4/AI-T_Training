package com.chapter13;

import java.util.*;

public class Main {
    public static void main(String... args) {
        Locale[] list = Locale.getAvailableLocales();
        Map<String, Locale> mapLocale = new HashMap<>();
        for (Locale i : list) {
            try {
                String currencyCode = Currency.getInstance(i).getCurrencyCode();
                if (!mapLocale.keySet().contains(currencyCode)) {
                    mapLocale.put(currencyCode, i);
                }
            } catch (IllegalArgumentException ex) {
//                ex.printStackTrace();
            }
        }
        for (Map.Entry<String, Locale> e : mapLocale.entrySet()) {
            print(e.getValue());
        }
    }

    private static void print(Locale locale) {
        System.out.println(
                locale.getDisplayCountry() + " : " +
                        Currency.getInstance(locale).getCurrencyCode() + " : " +
                        Currency.getInstance(locale).getSymbol());
    }
}

//        Croatia : HRK : HRK
//        Switzerland : CHF : CHF
//        Albania : ALL : ALL
//        Mexico : MXN : MXN
//        Guatemala : GTQ : GTQ
//        Chile : CLP : CLP
//        Honduras : HNL : HNL
//        South Africa : ZAR : ZAR
//        Tunisia : TND : TND
//        Vietnam : VND : VND
//        Australia : AUD : AUD
//        Israel : ILS : ILS
//        Bolivia : BOB : BOB
//        Indonesia : IDR : IDR
//        Sudan : SDG : SDG
//        Turkey : TRY : TRY
//        Lebanon : LBP : LBP
//        Iraq : IQD : IQD
//        Jordan : JOD : JOD
//        Cuba : CUP : CUP
//        United Arab Emirates : AED : AED
//        Taiwan : TWD : TWD
//        Hong Kong : HKD : HKD
//        Serbia : RSD : RSD
//        Belgium : EUR : EUR
//        Dominican Republic : DOP : DOP
//        Denmark : DKK : DKK
//        Malaysia : MYR : MYR
//        Canada : CAD : CAD
//        Bulgaria : BGN : BGN
//        Syria : SYP : SYP
//        Norway : NOK : NOK
//        Romania : RON : RON
//        Uruguay : UYU : UYU
//        Morocco : MAD : MAD
//        Czech Republic : CZK : CZK
//        Oman : OMR : OMR
//        Costa Rica : CRC : CRC
//        Sweden : SEK : SEK
//        Ukraine : UAH : UAH
//        Bahrain : BHD : BHD
//        El Salvador : SVC : SVC
//        Argentina : ARS : ARS
//        Qatar : QAR : QAR
//        Saudi Arabia : SAR : SAR
//        Yemen : YER : YER
//        India : INR : INR
//        Thailand : THB : THB
//        China : CNY : CNY
//        South Korea : KRW : KRW
//        Japan : JPY : JPY
//        Poland : PLN : PLN
//        United Kingdom : GBP : GBP
//        Serbia and Montenegro : CSD : CSD
//        Libya : LYD : LYD
//        Hungary : HUF : HUF
//        Philippines : PHP : PHP
//        Kuwait : KWD : KWD
//        Belarus : BYR : BYR
//        Russia : RUB : RUB
//        Paraguay : PYG : PYG
//        Iceland : ISK : ISK
//        Colombia : COP : COP
//        Puerto Rico : USD : $
//        Macedonia : MKD : MKD
//        Bosnia and Herzegovina : BAM : BAM
//        Egypt : EGP : EGP
//        Algeria : DZD : DZD
//        Panama : PAB : PAB
//        Singapore : SGD : SGD
//        Nicaragua : NIO : NIO
//        Venezuela : VEF : VEF
//        Peru : PEN : PEN
//        New Zealand : NZD : NZD
//        Brazil : BRL : BRL