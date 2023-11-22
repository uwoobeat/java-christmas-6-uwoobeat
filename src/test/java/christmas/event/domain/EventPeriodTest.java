package christmas.event.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.event.exception.InvalidEventPeriodException;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventPeriodTest {

    @DisplayName("대상 날짜가 이벤트 기간 내라면 참을 반환한다.")
    @Test
    void isWithinTrue() {

        LocalDate start = LocalDate.of(2023, 12, 1);
        LocalDate end = LocalDate.of(2023, 12, 25);
        EventPeriod eventPeriod = new EventPeriod(start, end);

        LocalDate target = LocalDate.of(2023, 12, 1);

        assertThat(eventPeriod.isWithin(target))
                .isTrue();
    }

    @DisplayName("대상 날짜가 이벤트 기간 외라면 거짓을 반환한다.")
    @Test
    void isWithinFalse() {

        LocalDate start = LocalDate.of(2023, 12, 1);
        LocalDate end = LocalDate.of(2023, 12, 25);
        EventPeriod eventPeriod = new EventPeriod(start, end);

        LocalDate target = LocalDate.of(2023, 12, 26);

        assertThat(eventPeriod.isWithin(target))
                .isFalse();
    }

    @DisplayName("이벤트 기간 시작일이 종료일 이후라면 예외가 발생한다.")
    @Test
    void createByInvalidTimeOrder() {

        LocalDate start = LocalDate.of(2023, 12, 25);
        LocalDate end = LocalDate.of(2023, 12, 1);

        assertThatThrownBy(() -> new EventPeriod(start, end))
                .isInstanceOf(InvalidEventPeriodException.class);
    }
}
