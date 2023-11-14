package christmas.event.domain;

import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.GiveawayPolicy;
import christmas.order.domain.Order;

public class GiveawayEvent extends Event {

    private final GiveawayPolicy giveawayPolicy;
    private final Giveaway giveaway;

    public GiveawayEvent(String name,
                         EventPeriod period,
                         GiveawayPolicy giveawayPolicy,
                         Giveaway giveaway) {
        super(name, period);
        this.giveawayPolicy = giveawayPolicy;
        this.giveaway = giveaway;
    }

    @Override
    protected boolean validateAdditionalConditions(Order order) {
        return giveawayPolicy.isGiveable(order);
    }
    
    public Giveaway give() {
        return giveaway;
    }
}
