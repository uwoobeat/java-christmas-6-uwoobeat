package christmas.badgepolicy.domain;

import christmas.reservation.domain.MoneyInfo;

public interface BadgeIssuePolicy {

    boolean isIssuable(MoneyInfo moneyInfo);
}
