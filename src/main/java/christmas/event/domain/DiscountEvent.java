package christmas.event.domain;

import christmas.common.domain.Money;
import christmas.datepolicy.domain.DatePolicy;
import christmas.discountpolicy.domain.DiscountPolicy;
import christmas.order.domain.Order;

public class DiscountEvent extends Event {

    private final DatePolicy datePolicy;
    private final DiscountPolicy discountPolicy;

    public DiscountEvent(String name,
                         EventPeriod period,
                         DatePolicy datePolicy,
                         DiscountPolicy discountPolicy) {
        super(name, period);
        this.datePolicy = datePolicy;
        this.discountPolicy = discountPolicy;
    }

    @Override
    protected boolean validateAdditionalConditions(Order order) {
        return datePolicy.isAppliable(order.getOrderedAt());
    }

    public Money discount(Order order) {
        return discountPolicy.discount(order);
    }
}
