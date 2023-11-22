package christmas.badgepolicy.domain;

import christmas.common.domain.Money;

public enum BadgePolicyFactory {
    STAR(new OrderBenefitPolicy(Constants.STAR_MINIMUM_ORDER_AMOUNT)),
    TREE(new OrderBenefitPolicy(Constants.TREE_MINIMUM_ORDER_AMOUNT)),
    SANTA(new OrderBenefitPolicy(Constants.SANTA_MINIMUM_ORDER_AMOUNT));

    private final BadgeIssuePolicy policy;

    BadgePolicyFactory(BadgeIssuePolicy policy) {
        this.policy = policy;
    }

    public BadgeIssuePolicy get() {
        return policy;
    }

    private static class Constants {
        public static final Money STAR_MINIMUM_ORDER_AMOUNT = new Money(5000);
        public static final Money TREE_MINIMUM_ORDER_AMOUNT = new Money(10000);
        public static final Money SANTA_MINIMUM_ORDER_AMOUNT = new Money(20000);
    }
}
