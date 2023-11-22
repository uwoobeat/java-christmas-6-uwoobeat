package christmas.datepolicy.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class DayOfWeekPolicy implements DatePolicy {

    private final List<DayOfWeek> daysOfWeek;

    public DayOfWeekPolicy(List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public boolean isAppliable(LocalDate date) {
        return daysOfWeek.contains(date.getDayOfWeek());
    }
}
