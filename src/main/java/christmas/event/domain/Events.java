package christmas.event.domain;

import christmas.common.domain.Money;
import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.Giveaways;
import christmas.order.domain.Order;
import java.util.List;

public class Events {

    private final List<Event> events;

    public Events(List<Event> events) {
        this.events = events;
    }

    public Money calculateDiscounts(Order order) {
        return events.stream()
                .filter(DiscountEvent.class::isInstance)
                .map(DiscountEvent.class::cast)
                .map(event -> event.discount(order))
                .reduce(new Money(0), Money::add);
    }

    public Giveaways getGiveaways() {
        List<Giveaway> giveaways = events.stream()
                .filter(GiveawayEvent.class::isInstance)
                .map(GiveawayEvent.class::cast)
                .map(GiveawayEvent::give)
                .toList();
        return new Giveaways(giveaways);
    }
}
