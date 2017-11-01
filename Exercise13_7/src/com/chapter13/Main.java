package com.chapter13;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Pattern;

public class Main {
    public static void main(String... args) {
        Locale[] list = Locale.getAvailableLocales();
        for (Locale i : list) {
            if (isDiff(i)) {
                System.out.print(i.getDisplayName() + " :");
                for (Month m : Month.values()) {
                    String display = m.getDisplayName(TextStyle.FULL, i);
                    String standalone = m.getDisplayName(TextStyle.FULL_STANDALONE, i);
                    if (!display.equals(standalone))
                        System.out.print(" " + display + "/" + standalone);
                }
                System.out.println();
            }
        }
    }

    private static boolean isDiff(Locale locale) {
        for (Month m : Month.values()) {
            String display = m.getDisplayName(TextStyle.FULL, locale);
            String standalone = m.getDisplayName(TextStyle.FULL_STANDALONE, locale);
            if (!Pattern.matches("^\\d+$", standalone))
                if (!display.equals(standalone))
                    return true;
        }
        return false;
    }
}

//        Croatian (Croatia) : siječnja/siječanj veljače/veljača ožujka/ožujak travnja/travanj svibnja/svibanj lipnja/lipanj srpnja/srpanj kolovoza/kolovoz rujna/rujan listopada/listopad studenoga/studeni prosinca/prosinac
//        Italian : gennaio/Gennaio febbraio/Febbraio marzo/Marzo aprile/Aprile maggio/Maggio giugno/Giugno luglio/Luglio agosto/Agosto settembre/Settembre ottobre/Ottobre novembre/Novembre dicembre/Dicembre
//        Ukrainian : січня/Січень лютого/Лютий березня/Березень квітня/Квітень травня/Травень червня/Червень липня/Липень серпня/Серпень вересня/Вересень жовтня/Жовтень листопада/Листопад грудня/Грудень
//        Slovak : januára/január februára/február marca/marec apríla/apríl mája/máj júna/jún júla/júl augusta/august septembra/september októbra/október novembra/november decembra/december
//        Finnish (Finland) : tammikuuta/tammikuu helmikuuta/helmikuu maaliskuuta/maaliskuu huhtikuuta/huhtikuu toukokuuta/toukokuu kesäkuuta/kesäkuu heinäkuuta/heinäkuu elokuuta/elokuu syyskuuta/syyskuu lokakuuta/lokakuu marraskuuta/marraskuu joulukuuta/joulukuu
//        Czech : ledna/leden února/únor března/březen dubna/duben května/květen června/červen července/červenec srpna/srpen října/říjen listopadu/listopad prosince/prosinec
//        Greek : Ιανουαρίου/Ιανουάριος Φεβρουαρίου/Φεβρουάριος Μαρτίου/Μάρτιος Απριλίου/Απρίλιος Μαΐου/Μάϊος Ιουνίου/Ιούνιος Ιουλίου/Ιούλιος Αυγούστου/Αύγουστος Σεπτεμβρίου/Σεπτέμβριος Οκτωβρίου/Οκτώβριος Νοεμβρίου/Νοέμβριος Δεκεμβρίου/Δεκέμβριος
//        Ukrainian (Ukraine) : січня/Січень лютого/Лютий березня/Березень квітня/Квітень травня/Травень червня/Червень липня/Липень серпня/Серпень вересня/Вересень жовтня/Жовтень листопада/Листопад грудня/Грудень
//        Czech (Czech Republic) : ledna/leden února/únor března/březen dubna/duben května/květen června/červen července/červenec srpna/srpen října/říjen listopadu/listopad prosince/prosinec
//        Polish (Poland) : stycznia/styczeń lutego/luty marca/marzec kwietnia/kwiecień maja/maj czerwca/czerwiec lipca/lipiec sierpnia/sierpień września/wrzesień października/październik listopada/listopad grudnia/grudzień
//        Catalan (Spain) : de gener/gener de febrer/febrer de març/març d’abril/abril de maig/maig de juny/juny de juliol/juliol d’agost/agost de setembre/setembre d’octubre/octubre de novembre/novembre de desembre/desembre
//        Croatian : siječnja/siječanj veljače/veljača ožujka/ožujak travnja/travanj svibnja/svibanj lipnja/lipanj srpnja/srpanj kolovoza/kolovoz rujna/rujan listopada/listopad studenoga/studeni prosinca/prosinac
//        Lithuanian : sausio/Sausio vasaris/Vasario kovas/Kovo balandis/Balandžio gegužė/Gegužės birželis/Birželio liepa/Liepos rugpjūtis/Rugpjūčio rugsėjis/Rugsėjo spalis/Spalio lapkritis/Lapkričio gruodis/Gruodžio
//        Catalan : de gener/gener de febrer/febrer de març/març d’abril/abril de maig/maig de juny/juny de juliol/juliol d’agost/agost de setembre/setembre d’octubre/octubre de novembre/novembre de desembre/desembre
//        Greek (Cyprus) : Μάιος/Μάϊος
//        Russian (Russia) : января/Январь февраля/Февраль марта/Март апреля/Апрель мая/Май июня/Июнь июля/Июль августа/Август сентября/Сентябрь октября/Октябрь ноября/Ноябрь декабря/Декабрь
//        Finnish : tammikuuta/tammikuu helmikuuta/helmikuu maaliskuuta/maaliskuu huhtikuuta/huhtikuu toukokuuta/toukokuu kesäkuuta/kesäkuu heinäkuuta/heinäkuu elokuuta/elokuu syyskuuta/syyskuu lokakuuta/lokakuu marraskuuta/marraskuu joulukuuta/joulukuu
//        Russian : января/Январь февраля/Февраль марта/Март апреля/Апрель мая/Май июня/Июнь июля/Июль августа/Август сентября/Сентябрь октября/Октябрь ноября/Ноябрь декабря/Декабрь
//        Greek (Greece) : Ιανουαρίου/Ιανουάριος Φεβρουαρίου/Φεβρουάριος Μαρτίου/Μάρτιος Απριλίου/Απρίλιος Μαΐου/Μάϊος Ιουνίου/Ιούνιος Ιουλίου/Ιούλιος Αυγούστου/Αύγουστος Σεπτεμβρίου/Σεπτέμβριος Οκτωβρίου/Οκτώβριος Νοεμβρίου/Νοέμβριος Δεκεμβρίου/Δεκέμβριος
//        Italian (Switzerland) : gennaio/Gennaio febbraio/Febbraio marzo/Marzo aprile/Aprile maggio/Maggio giugno/Giugno luglio/Luglio agosto/Agosto settembre/Settembre ottobre/Ottobre novembre/Novembre dicembre/Dicembre
//        Slovak (Slovakia) : januára/január februára/február marca/marec apríla/apríl mája/máj júna/jún júla/júl augusta/august septembra/september októbra/október novembra/november decembra/december
//        Lithuanian (Lithuania) : sausio/Sausio vasaris/Vasario kovas/Kovo balandis/Balandžio gegužė/Gegužės birželis/Birželio liepa/Liepos rugpjūtis/Rugpjūčio rugsėjis/Rugsėjo spalis/Spalio lapkritis/Lapkričio gruodis/Gruodžio
//        Italian (Italy) : gennaio/Gennaio febbraio/Febbraio marzo/Marzo aprile/Aprile maggio/Maggio giugno/Giugno luglio/Luglio agosto/Agosto settembre/Settembre ottobre/Ottobre novembre/Novembre dicembre/Dicembre
//        Polish : stycznia/styczeń lutego/luty marca/marzec kwietnia/kwiecień maja/maj czerwca/czerwiec lipca/lipiec sierpnia/sierpień września/wrzesień października/październik listopada/listopad grudnia/grudzień
