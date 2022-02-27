package Day3.DateTime;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/*
Note: all methods below are static.
1. TemporalAdjuster ofDateAdjuster(UnaryOperator<LocalDate> dateBasedAdjuster)

2. TemporalAdjuster firstDayOfMonth(): Returns the "first day of month" adjuster, which returns a new date set to the first day of the current month.
3. TemporalAdjuster lastDayOfMonth() : Returns the "last day of month" adjuster, which returns a new date set to the last day of the current month.

4. TemporalAdjuster firstDayOfNextMonth() : Returns the "first day of next month" adjuster, which returns a new date set to the first day of the next month.

5. TemporalAdjuster firstDayOfYear() : Returns the "first day of year" adjuster, which returns a new date set to the first day of the current year.
6. TemporalAdjuster lastDayOfYear() : Returns the "last day of year" adjuster, which returns a new date set to the last day of the current year.

7. TemporalAdjuster firstDayOfNextYear() : Returns the "first day of next year" adjuster, which returns a new date set to the first day of the next year.

8. TemporalAdjuster firstInMonth(DayOfWeek dayOfWeek): Returns the first in month adjuster, which returns a new date in the same month
                                                       with the first matching day-of-week.
9. TemporalAdjuster lastInMonth(DayOfWeek dayOfWeek) : Returns the last in month adjuster, which returns a new date in the same month
                                                       with the last matching day-of-week.

10. TemporalAdjuster dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek) : Returns the day-of-week in month adjuster, which returns a
                                                                          new date in the same month with the ordinal day-of-week.

11. TemporalAdjuster next(DayOfWeek dayOfWeek) : Returns the next day-of-week adjuster, which adjusts the date to the first occurrence of
                                                 the specified day-of-week after the date being adjusted.

12. TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) : Returns the next-or-same day-of-week adjuster, which adjusts the date to the first
                                                       occurrence of the specified day-of-week after the date being adjusted unless it is already on
                                                       that day in which case the same object is returned.

13. TemporalAdjuster previous(DayOfWeek dayOfWeek) : Returns the previous day-of-week adjuster, which adjusts the date to the first occurrence of the
                                                     specified day-of-week before the date being adjusted.

14. TemporalAdjuster previousOrSame(DayOfWeek dayOfWeek) : Returns the previous-or-same day-of-week adjuster, which adjusts the date to the first occurrence
                                                           of the specified day-of-week before the date being adjusted unless it is already on that day in which
                                                           case the same object is returned.

*/
// https://o7planning.org/13749/java-temporaladjuster for detailed example.

// Note: TemporalAdjusters is consisting of useful static method to get TemporalAdjuster object. They are different

public class TemporalAdjusterDemo {
    public static void main(String[] args) {
        TemporalAdjuster add2DaysAdjuster = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(2));
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.firstDayOfMonth();
        TemporalAdjuster temporalAdjuster1 = TemporalAdjusters.lastDayOfMonth();

        // System.out.println(temporalAdjuster.adjustInto(LocalDate.now()));

        DayOfWeek dayOfWeek = (
                (LocalDate)temporalAdjuster.adjustInto(LocalDate.now())  // temporalAdjuster = first day of the month, we adjust this of current date. so it will
        ).getDayOfWeek();                                                // provide the first day of current month. then we type cast it to LocalDate to get
                                                                         // the Day of week.





        // we can use this object to adjust specific parts of date,time, zone etc. We can also create our own custom class implementing TemporalAdjuster interface,
        // and overriding adjustInto(Temporal temporal) method.
        // Some use cases example (all codes are given in the link above) of TemporalAdjuster class:
            // 1. We can create TruncateTimeAdjuster class to truncate the time (hours, minutes, seconds, nanoseconds) of a Temporal object, but keep the rest
            // 2. Adjust all given Temporal objects to May 2000, other fields remain unchanged.
            // 3. Adjust the zone-offset for the given OffsetDateTime objects to +15;
            // 4. Assume that the working days of the week are from Monday to Friday. We write NextWorkingDayAdjuster class to find the next working
            //    day after the given date.
            // 5. NextChristmasAdjuster class to find the next Christmas date:
            // 6.



    }
}
