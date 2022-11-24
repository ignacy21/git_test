package src.CZ1.formatting;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        //Locale
//        int number = 1_234_567;
//        Locale localePL = new Locale("pl", "PL");
//        Locale localeUS = Locale.US;
//        Locale localeGERMANY = Locale.GERMANY;
//
//        System.out.println("NumberFormat.getInstance()");
//        System.out.println("PL: " + NumberFormat.getInstance(localePL).format(number));
//        System.out.println("US: " + NumberFormat.getInstance(localeUS).format(number));
//        System.out.println("GERMANY: " + NumberFormat.getInstance(localeGERMANY).format(number));
//        System.out.println();
//
//        System.out.println("NumberFormat.getNumberInstance()");
//        System.out.println("PL: " + NumberFormat.getNumberInstance(localePL).format(number));
//        System.out.println("US: " + NumberFormat.getNumberInstance(localeUS).format(number));
//        System.out.println("GERMANY: " + NumberFormat.getNumberInstance(localeGERMANY).format(number));
//        System.out.println();
//
//        System.out.println("NumberFormat.getPercentInstance()");
//        System.out.println("PL: " + NumberFormat.getPercentInstance(localePL).format(number));
//        System.out.println("US: " + NumberFormat.getPercentInstance(localeUS).format(number));
//        System.out.println("GERMANY: " + NumberFormat.getPercentInstance(localeGERMANY).format(number));
//        System.out.println();
//
//        System.out.println("NumberFormat.getCurrencyInstance()");
//        System.out.println("PL: " + NumberFormat.getCurrencyInstance(localePL).format(number));
//        System.out.println("US: " + NumberFormat.getCurrencyInstance(localeUS).format(number));
//        System.out.println("GERMANY: " + NumberFormat.getCurrencyInstance(localeGERMANY).format(number));
//        System.out.println();

        LocalDate localDate = LocalDate.of(2020, 2, 10);
        LocalTime localTime = LocalTime.of(20, 12, 50);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(3));
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Poland"));

//        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
//        System.out.println(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
//        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//        System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
//        System.out.println(zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        DateTimeFormatter formatter_FULL_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US);
        DateTimeFormatter formatter_LONG_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US);
        DateTimeFormatter formatter_MEDIUM_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US);
        DateTimeFormatter formatter_SHORT_US = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US);

        DateTimeFormatter formatter_FULL_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_LONG_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_MEDIUM_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMANY);
        DateTimeFormatter formatter_SHORT_GERMANY = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMANY);

        System.out.println("FULL_US: " + zonedDateTime.format(formatter_FULL_US));
        System.out.println("FULL_GERMANY: " + zonedDateTime.format(formatter_FULL_GERMANY));
        System.out.println("LONG_US: " + zonedDateTime.format(formatter_LONG_US));
        System.out.println("LONG_GERMANY: " + zonedDateTime.format(formatter_LONG_GERMANY));
        System.out.println("MEDIUM_US: " + zonedDateTime.format(formatter_MEDIUM_US));
        System.out.println("MEDIUM_GERMANY: " + zonedDateTime.format(formatter_MEDIUM_GERMANY));
        System.out.println("SHORT_US: " + zonedDateTime.format(formatter_SHORT_US));
        System.out.println("SHORT_GERMANY: " + zonedDateTime.format(formatter_SHORT_GERMANY));
    }
}
