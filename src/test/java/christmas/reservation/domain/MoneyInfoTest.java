package christmas.reservation.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyInfoTest {

    @DisplayName("총혜택금액은 총할인금액과 총증정금액의 합이다.")
    @Test
    void calculateBenefitAmount() {
        MoneyInfo moneyInfo = MoneyInfo.of(
                new Money(10000),
                new Money(2000),
                new Money(3000));

        assertThat(moneyInfo.benefitAmount())
                .isEqualTo(new Money(5000));
    }

    @DisplayName("예상결제금액은 총주문금액에서 총할인금액을 뺀 금액이다.")
    @Test
    void calculateWillPaidAmount() {
        MoneyInfo moneyInfo = MoneyInfo.of(
                new Money(10000),
                new Money(2000),
                new Money(3000));

        assertThat(moneyInfo.willPaidAmount())
                .isEqualTo(new Money(8000));
    }
}
