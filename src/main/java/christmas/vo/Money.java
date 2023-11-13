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

    public Money add(Money target) {
        return new Money(this.amount + target.amount);
    }

    public Money subtract(Money target) {
        return new Money(this.amount - target.amount);
    }

    public Money multiply(int target) {
        return new Money(this.amount * target);
    }
}
