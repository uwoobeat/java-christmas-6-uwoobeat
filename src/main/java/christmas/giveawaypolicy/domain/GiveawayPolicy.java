package christmas.giveawaypolicy.domain;

import christmas.common.domain.Money;
import christmas.order.domain.Order;

public class GiveawayPolicy {

    private final Money criteria;

    public GiveawayPolicy(Money criteria) {
        this.criteria = criteria;
    }

    public boolean isGiveable(Order order) {
        return order.calculateTotalPrice().isGreaterOrEqual(criteria);
    }
}
