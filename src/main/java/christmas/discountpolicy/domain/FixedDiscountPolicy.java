package christmas.discountpolicy.domain;

import christmas.common.domain.Money;
import christmas.order.domain.Order;

public class FixedDiscountPolicy implements DiscountPolicy {

    private final Money discountAmount;

    public FixedDiscountPolicy(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public Money discount(Order order) {
        return discountAmount;
    }
}
