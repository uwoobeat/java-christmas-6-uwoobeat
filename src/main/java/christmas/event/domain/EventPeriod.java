package christmas.event.domain;

import christmas.event.exception.InvalidEventPeriodException;
import java.time.LocalDate;

public record EventPeriod(
        LocalDate start,
        LocalDate end
) {

    public EventPeriod {
        validateTimeOrder(start, end);
    }

    private void validateTimeOrder(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new InvalidEventPeriodException();
        }
    }

    public boolean isWithin(LocalDate date) {
        return !date.isBefore(start) && !date.isAfter(end);
    }
}
