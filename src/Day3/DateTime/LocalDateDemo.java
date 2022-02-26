package Day3.DateTime;

import java.time.*;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

// Java LocalDate class is an immutable class that represents Date with a default format of yyyy-mm-dd
public class LocalDateDemo {
    public static void main(String[] args) {
        /*
        LocalDate.MAX = '+999999999-12-31' and LocalDate.MIN = '-999999999-01-01' static constants
         */

        // 1. different ways of getting localDate
        LocalDate localDate = LocalDate.now();                              // Obtains the current date from the system clock in the default time-zone.
        LocalDate localDate1 = LocalDate.now(Clock.systemDefaultZone());    // Obtains the current date from the specified clock.
        LocalDate localDate2 = LocalDate.now(ZoneId.of("Asia/Kolkata"));    // Obtains the current date from the system clock in the specified time-zone.
        LocalDate localDate3 = LocalDate.of(2020, Month.APRIL, 29);         // Obtains an instance of LocalDate from a year, month and day.
        // Obtains an instance of LocalDate from a text string such as 2007-12-03, check the documentation for details about Date time formatter
        LocalDate localDate4 = LocalDate.parse("2015-11-20", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate localDate5 = LocalDate.from(localDate);           // Obtains an instance of LocalDate from a temporal object.

        // 2. different ways getting LocalDateTime from LocalDate Object
        LocalDateTime localDateTime = localDate.atTime(10,15,53,200); // this has 2 more overload, each excluding nanosecond and seconds
        LocalDateTime localDateTime2 = localDate.atTime(LocalTime.now());   // Combines this date with a time to create a LocalDateTime.
        LocalDateTime localDateTime1 = localDate.atStartOfDay();    // Combines this date with the time of midnight to create a LocalDateTime at the start of this date.


        int comparing = localDate.compareTo(localDate1);    // Compares this date to another date.
        boolean isEqual = localDate.equals(localDate1);     // Checks if this date is equal to another date.
        String formatted = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // Formats this date using the specified formatter.
        boolean isAfter= localDate.isAfter(localDate1);     // Checks if this date is after the specified date.
        boolean isBefore = localDate.isBefore(localDate1);      // Checks if this date is before the specified date.
        boolean isEqualTo = localDate.isEqual(localDate1);    // Checks if this date is equal to the specified date.
        boolean isLeapYear = localDate.isLeapYear();            // Checks if the year is a leap year, according to the ISO proleptic calendar system rules.
        boolean isSupported = localDate.isSupported(ChronoField.HOUR_OF_DAY);          // Checks if the specified field or unit is supported.



        int month = localDate.getDayOfMonth();      // Gets the day-of-month field.
        DayOfWeek dayOfWeek = localDate.getDayOfWeek(); // Gets the day-of-week field, which is an enum DayOfWeek.
        Month month1 = localDate.getMonth();        // Gets the month-of-year field using the Month enum.
        int month2 = localDate.getMonthValue();     // Gets the month-of-year field from 1 to 12.
        int lengthOfMonth= localDate.lengthOfMonth(); //Returns the length of the month represented by this date.
        int dayOfYear = localDate.getDayOfYear();  // Gets the day-of-year field.
        int year = localDate.getYear();             // Gets the year field.
        int lengthOfYear = localDate.lengthOfYear();    //Returns the length of the year represented by this date.
        Era era = localDate.getEra();               // Gets the era applicable at this date.
        long time = localDate.getLong(ChronoField.DAY_OF_MONTH);   // Gets the value of the specified field from this date as a long.


        // add or subtract specific day,time,month, week. There are two overloads of plus and minus method as well take a look at them from doc
        LocalDate yesterday = localDate.minusDays(1);       // Returns a copy of this LocalDate with the specified number of days subtracted.
        LocalDate lastWeek = localDate.minusWeeks(1);       // Returns a copy of this LocalDate with the specified number of weeks subtracted.
        LocalDate lastMonth = localDate.minusMonths(1);     // Returns a copy of this LocalDate with the specified number of months subtracted.
        LocalDate lastYear = localDate.minusYears(1);       // Returns a copy of this LocalDate with the specified number of years subtracted.

        LocalDate tomorrow = localDate.plusDays(1);         // Returns a copy of this LocalDate with the specified number of days added.
        LocalDate nextWeek = localDate.plusWeeks(1);        // Returns a copy of this LocalDate with the specified number of weeks added.
        LocalDate nextMonth = localDate.plusMonths(1);      // Returns a copy of this LocalDate with the specified number of months added.
        LocalDate nextYear = localDate.plusYears(1);        // Returns a copy of this LocalDate with the specified number of years added.

    }
}
