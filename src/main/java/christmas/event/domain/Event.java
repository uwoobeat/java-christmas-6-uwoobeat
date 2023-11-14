package christmas.event.domain;

import christmas.common.domain.Money;
import christmas.order.domain.Order;

public abstract class Event {

    public static final Money MINIMUM_ORDER_PRICE = new Money(10000);
    private final String name;
    private final EventPeriod period;

    public Event(String name, EventPeriod period) {
        this.name = name;
        this.period = period;
    }

    private boolean validatePeriod(Order order) {
        return period.isWithin(order.getOrderedAt());
    }

    private boolean validateTotalPrice(Order order) {
        return order.calculateTotalAmount().isGreaterOrEqual(MINIMUM_ORDER_PRICE);
    }

    public final boolean isAppliable(Order order) {
        return validateTotalPrice(order) &&
                validatePeriod(order) &&
                validateAdditionalConditions(order);
    }

    protected abstract boolean validateAdditionalConditions(Order order);
}
