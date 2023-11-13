package christmas.datepolicy.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public enum DatePolicyFactory {
    EVERYDAY(new DayOfWeekPolicy(Constants.EVERYDAY_LIST)),

    WEEKDAY(new DayOfWeekPolicy(Constants.WEEKDAY_LIST)),

    WEEKEND(new DayOfWeekPolicy(Constants.WEEKEND_LIST)),

    SPECIAL(new FixedDatePolicy(Constants.STARRED_DATE_LIST));

    private final DatePolicy datePolicy;

    DatePolicyFactory(DatePolicy datePolicy) {
        this.datePolicy = datePolicy;
    }

    public boolean isAppliable(LocalDate date) {
        return datePolicy.isAppliable(date);
    }

    private static class Constants {
        public static final List<DayOfWeek> EVERYDAY_LIST = List.of(
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY);
        public static final List<DayOfWeek> WEEKDAY_LIST = List.of(
                DayOfWeek.SUNDAY,
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY);
        public static final List<DayOfWeek> WEEKEND_LIST = List.of(
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY);
        public static final List<LocalDate> STARRED_DATE_LIST = List.of(
                LocalDate.of(2023, 12, 3),
                LocalDate.of(2023, 12, 10),
                LocalDate.of(2023, 12, 17),
                LocalDate.of(2023, 12, 24),
                LocalDate.of(2023, 12, 25),
                LocalDate.of(2023, 12, 31));
    }
}
