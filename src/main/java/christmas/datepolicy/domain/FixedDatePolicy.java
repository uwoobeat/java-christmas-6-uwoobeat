package christmas.datepolicy.domain;

import java.time.LocalDate;
import java.util.List;

public class FixedDatePolicy implements DatePolicy {

    private final List<LocalDate> dates;

    public FixedDatePolicy(List<LocalDate> dates) {
        this.dates = dates;
    }

    @Override
    public boolean isAppliable(LocalDate date) {
        return dates.contains(date);
    }
}
