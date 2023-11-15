package christmas.event.domain;

import christmas.common.domain.Money;
import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.Giveaways;
import christmas.order.domain.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events {

    private final Map<Event, Money> eventBenefits;

    private Events(Map<Event, Money> eventBenefits) {
        this.eventBenefits = eventBenefits;
    }

    public Map<Event, Money> getEventMap() {
        return eventBenefits;
    }

    private List<Event> getEventList() {
        return List.copyOf(eventBenefits.keySet());
    }

    public static Events from(List<Event> events, Order order) {
        Map<Event, Money> eventBenefits = events.stream()
                .filter(event -> event.isAppliable(order))
                .collect(HashMap::new, (map, event) -> map.put(event, event.getBenefit(order)), HashMap::putAll);

        return new Events(eventBenefits);
    }

    public Money calculateDiscounts(Order order) {
        return getEventList().stream()
                .filter(DiscountEvent.class::isInstance)
                .map(DiscountEvent.class::cast)
                .map(event -> event.discount(order))
                .reduce(new Money(0), Money::add);
    }

    public Giveaways getGiveaways() {
        List<Giveaway> giveaways = getEventList().stream()
                .filter(GiveawayEvent.class::isInstance)
                .map(GiveawayEvent.class::cast)
                .map(GiveawayEvent::give)
                .toList();

        return new Giveaways(giveaways);
    }
}
