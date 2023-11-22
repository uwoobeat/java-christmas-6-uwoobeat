package christmas.discountpolicy.domain;

import christmas.common.domain.Money;
import christmas.order.domain.Order;

public interface DiscountPolicy {

    Money discount(Order order);
}
