package christmas.badgepolicy.domain;

import christmas.common.domain.Money;
import christmas.reservation.domain.MoneyInfo;

public class OrderBenefitPolicy implements BadgeIssuePolicy {

    private final Money criteria;

    public OrderBenefitPolicy(Money criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean isIssuable(MoneyInfo moneyInfo) {
        return moneyInfo.benefitAmount().isGreaterOrEqual(criteria);
    }
}
