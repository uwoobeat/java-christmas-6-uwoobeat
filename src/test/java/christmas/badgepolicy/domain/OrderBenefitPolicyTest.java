package christmas.badgepolicy.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.domain.Money;
import christmas.reservation.domain.MoneyInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderBenefitPolicyTest {

    @DisplayName("총혜택금액이 기준금액 이상이면 발급 가능여부는 참이다.")
    @ParameterizedTest
    @ValueSource(ints = {1199, 1200})
    void isBenefitable(int criteria) {
        OrderBenefitPolicy policy = new OrderBenefitPolicy(new Money(criteria));

        // 총혜택금액 = 500 + 700 = 1200
        MoneyInfo moneyInfo = MoneyInfo.of(new Money(1000), new Money(500), new Money(700));

        assertThat(policy.isIssuable(moneyInfo)).isTrue();
    }

    @DisplayName("총혜택금액이 기준금액 미만이면 발급 가능여부는 거짓이다.")
    @ParameterizedTest
    @ValueSource(ints = {1201, 1500})
    void isNotBenefitable(int benefitAmount) {
        OrderBenefitPolicy policy = new OrderBenefitPolicy(new Money(benefitAmount));

        // 전체 혜택금액 = 500 + 700 = 1200
        MoneyInfo moneyInfo = MoneyInfo.of(new Money(1000), new Money(500), new Money(700));

        assertThat(policy.isIssuable(moneyInfo)).isFalse();
    }
}
