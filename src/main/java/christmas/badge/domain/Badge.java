package christmas.badge.domain;

import christmas.badgepolicy.domain.BadgeIssuePolicy;
import christmas.reservation.domain.MoneyInfo;

public class Badge {

    private final String name;
    private final BadgeIssuePolicy policy;

    public Badge(String name, BadgeIssuePolicy policy) {
        this.name = name;
        this.policy = policy;
    }

    public boolean isIssuable(MoneyInfo info) {
        return policy.isIssuable(info);
    }

    public String getName() {
        return name;
    }
}
