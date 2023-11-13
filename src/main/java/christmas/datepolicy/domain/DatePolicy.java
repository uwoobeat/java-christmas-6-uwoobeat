package christmas.datepolicy.domain;

import java.time.LocalDate;

public interface DatePolicy {

    public boolean isAppliable(LocalDate date);
}
