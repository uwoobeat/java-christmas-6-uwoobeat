package christmas.vo;

import christmas.exception.InvalidMoneyException;

public record Money(int amount) {

    public Money {
        validatePositive(amount);
    }

    private void validatePositive(int amount) {
        if (amount < 0) {
            throw new InvalidMoneyException();
        }
    }
}
