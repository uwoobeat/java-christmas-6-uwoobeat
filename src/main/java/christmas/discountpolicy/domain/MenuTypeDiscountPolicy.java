package christmas.discountpolicy.domain;

import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import christmas.order.domain.Order;

public class MenuTypeDiscountPolicy implements DiscountPolicy {

    private final MenuType condition;
    private final Money discountUnit;

    public MenuTypeDiscountPolicy(MenuType condition, Money discountUnit) {
        this.condition = condition;
        this.discountUnit = discountUnit;
    }

    @Override
    public Money discount(Order order) {
        int count = order.countByType(condition);
        return discountUnit.multiply(count);
    }
}
