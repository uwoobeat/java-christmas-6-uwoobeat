package christmas.discountpolicy.domain;

import christmas.common.domain.Money;
import christmas.order.domain.Order;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ElapsedDayDiscountPolicy implements DiscountPolicy {

    private final LocalDate targetDate;
    private final Money baseAmount;
    private final Money stepAmount;

    public ElapsedDayDiscountPolicy(LocalDate targetDate, Money baseAmount, Money stepAmount) {
        this.targetDate = targetDate;
        this.baseAmount = baseAmount;
        this.stepAmount = stepAmount;
    }

    private int getElapsedDays(Order order) {
        return (int) ChronoUnit.DAYS.between(targetDate, order.getOrderedAt());
    }

    @Override
    public Money discount(Order order) {
        int elapsedDays = getElapsedDays(order);
        return stepAmount.multiply(elapsedDays).add(baseAmount);
    }
}
