package christmas.badge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.badgepolicy.domain.BadgeIssuePolicy;
import christmas.reservation.domain.MoneyInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    static class FixedIssuePolicy implements BadgeIssuePolicy {

        private boolean isIssuable = true;

        public void setIssuable(boolean isIssuable) {
            this.isIssuable = isIssuable;
        }

        @Override
        public boolean isIssuable(MoneyInfo moneyInfo) {
            return isIssuable;
        }
    }


    @DisplayName("배지 발급 정책이 참이면 배지를 발급할 수 있다.")
    @Test
    void isIssuable() {
        FixedIssuePolicy policy = new FixedIssuePolicy();
        policy.setIssuable(true);

        Badge badge = new Badge("테스트 배지", policy);

        assertThat(badge.isIssuable(null)).isTrue();
    }

    @DisplayName("배지 발급 정책이 거짓이면 배지를 발급할 수 없다.")
    @Test
    void isNotIssuable() {
        FixedIssuePolicy policy = new FixedIssuePolicy();
        policy.setIssuable(false);

        Badge badge = new Badge("테스트 배지", policy);

        assertThat(badge.isIssuable(null)).isFalse();
    }
}
