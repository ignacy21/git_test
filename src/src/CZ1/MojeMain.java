package src.CZ1;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class MojeMain {

    public static void main(String[] args) {

        int number = 1_345_987;

        Locale localeUK = Locale.UK;
        Locale localeGERMANY = Locale.GERMANY;
        Locale localePL = new Locale("PL");
        Locale localeKorea = Locale.KOREA;


        String instanceLocaleUK = NumberFormat.getNumberInstance(localeUK).format(number);
        String instanceLocaleGERMANY = NumberFormat.getNumberInstance(localeGERMANY).format(number);
        String instanceLocalePL = NumberFormat.getNumberInstance(localePL).format(number);
        System.out.println(instanceLocalePL);
        System.out.println(instanceLocaleGERMANY);
        System.out.println(instanceLocaleUK);
        System.out.println();
//        String currencyFormat = NumberFormat.getCurrencyInstance(localeGERMANY).format(number);
        System.out.println(NumberFormat.getCurrencyInstance(localeKorea).format(number));
        String currencyFormat = NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE).format(number);
        System.out.println(currencyFormat);
        System.out.println();
        System.out.println(NumberFormat.getPercentInstance(localePL).format(number));
        System.out.println(NumberFormat.getPercentInstance(localeGERMANY).format(number));
        System.out.println(NumberFormat.getPercentInstance(localeUK).format(number));


        LocalDate localDate = LocalDate.of(2021, 12, 31);
        LocalTime localTime = LocalTime.of(12, 59, 59);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        ZonedDateTime zonePoland = ZonedDateTime.of(localDateTime, ZoneId.of("Poland"));
        ZonedDateTime zoneAsiaAqtau = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Aqtau"));

        System.out.println();
        System.out.println(ZoneId.getAvailableZoneIds());
        DateTimeFormatter formatter_FULL_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(localeGERMANY);
        DateTimeFormatter formatterGERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeGERMANY);
        DateTimeFormatter formatter_FULL_PL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(localePL);
        DateTimeFormatter formatterPL = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localePL);
        DateTimeFormatter formatterUK = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeUK);
        DateTimeFormatter formatterKOREA = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeKorea);

        System.out.println(localDateTime.format(formatterGERMANY));
        System.out.println(zonePoland.format(formatter_FULL_GERMANY));
        System.out.println(zonePoland.format(formatter_FULL_PL));
        System.out.println(zoneAsiaAqtau.format(formatter_FULL_PL));
        System.out.println(zoneAsiaAqtau.format(formatterKOREA));


    }
}
