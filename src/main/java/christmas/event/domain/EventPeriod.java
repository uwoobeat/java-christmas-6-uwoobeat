package christmas.event.domain;

import java.time.LocalDate;

public record EventPeriod(
        LocalDate start,
        LocalDate end
) {

    public boolean isWithin(LocalDate date) {
        return !date.isBefore(start) && !date.isAfter(end);
    }
}
