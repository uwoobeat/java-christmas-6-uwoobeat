package christmas.giveawaypolicy.domain;

import christmas.common.domain.Money;
import java.util.List;

public class Giveaways {

    List<Giveaway> giveaways;

    public Giveaways(List<Giveaway> giveaways) {
        this.giveaways = giveaways;
    }

    public Money calculateValueAmount() {
        return giveaways.stream()
                .map(Giveaway::value)
                .reduce(Money.zero(), Money::add);
    }

    public List<Giveaway> getGiveaways() {
        return giveaways;
    }
}
