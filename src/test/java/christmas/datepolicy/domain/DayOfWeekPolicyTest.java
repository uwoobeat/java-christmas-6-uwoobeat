package christmas.datepolicy.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfWeekPolicyTest {

    @DisplayName("대상 날짜가 요일 리스트에 포함되어 있다면 적용할 수 있다.")
    @Test
    void isAppliable() {
        LocalDate target = LocalDate.of(2023, 11, 14);

        assertThat(DatePolicyFactory.EVERYDAY.isAppliable(target))
                .isTrue();
    }

    @DisplayName("대상 날짜가 요일 리스트에 포함되지 않았다면 적용할 수 없다.")
    @Test
    void isNotAppliable() {
        LocalDate target = LocalDate.of(2023, 11, 14);  // 화요일

        assertThat(DatePolicyFactory.WEEKEND.isAppliable(target))
                .isFalse();
    }
}
