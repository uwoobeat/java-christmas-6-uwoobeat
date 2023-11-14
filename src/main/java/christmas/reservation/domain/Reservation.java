package christmas.reservation.domain;

import christmas.badge.domain.Badge;
import christmas.event.domain.EventFactory;
import christmas.event.domain.Events;
import christmas.giveawaypolicy.domain.Giveaways;
import christmas.order.domain.Order;

public class Reservation {

    private final Order order;
    private final Events applied;
    private final Giveaways giveaways;
    private final MoneyInfo moneyInfo;
    private final Badge badge;


    private Reservation(Order order, Events applied, Giveaways giveaways, MoneyInfo moneyInfo, Badge badge) {
        this.order = order;
        this.applied = applied;
        this.giveaways = giveaways;
        this.moneyInfo = moneyInfo;
        this.badge = badge;
    }

    public static Reservation of(Order order) {
        Events applied = EventFactory.getAppliableEvents(order);
        Giveaways giveaways = applied.getGiveaways();
        MoneyInfo moneyInfo = MoneyInfo.of(
                order.calculateTotalAmount(),
                applied.calculateDiscounts(order),
                giveaways.calculateValueAmount());

        return new Reservation(order, applied, giveaways, moneyInfo, null);
    }
}
