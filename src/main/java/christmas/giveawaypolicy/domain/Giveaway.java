package christmas.giveawaypolicy.domain;

import christmas.common.domain.Menu;
import christmas.common.domain.Money;
import christmas.giveawaypolicy.exception.InvalidGiveawayException;

public record Giveaway(
        Menu menu,
        int quantity
) {

    public Giveaway {
        validateQuantityPositive(quantity);
    }

    private void validateQuantityPositive(int quantity) {
        if (quantity <= 0) {
            throw new InvalidGiveawayException();
        }
    }

    public Money value() {
        return menu.price().multiply(quantity);
    }
}
