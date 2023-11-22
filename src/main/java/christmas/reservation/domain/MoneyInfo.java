package christmas.reservation.domain;

import christmas.common.domain.Money;

public record MoneyInfo(
        Money orderedAmount,
        Money discountAmount,
        Money benefitAmount,
        Money willPaidAmount
) {

    public static MoneyInfo of(Money orderedAmount, Money discountAmount, Money givewayAmount) {
        return new MoneyInfo(
                orderedAmount,
                discountAmount,
                discountAmount.add(givewayAmount),
                orderedAmount.subtract(discountAmount));
    }
}
