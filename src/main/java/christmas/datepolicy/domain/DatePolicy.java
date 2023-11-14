package christmas.datepolicy.domain;

import java.time.LocalDate;

public interface DatePolicy {

    boolean isAppliable(LocalDate date);
}
