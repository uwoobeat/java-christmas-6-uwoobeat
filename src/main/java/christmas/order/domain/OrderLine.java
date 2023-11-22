package christmas.order.domain;

import christmas.common.domain.Menu;
import christmas.common.domain.Money;
import christmas.order.exception.InvalidQuantityException;

public record OrderLine(
        Menu menu,
        int quantity
) {

    public OrderLine {
        validateQuantityPositive(quantity);
    }

    private void validateQuantityPositive(int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException();
        }
    }

    public Money calculatePrice() {
        return menu.price().multiply(quantity);
    }
}
