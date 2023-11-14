package christmas.event.domain;

import christmas.common.domain.MenuFactory;
import christmas.datepolicy.domain.DatePolicyFactory;
import christmas.discountpolicy.domain.DiscountPolicyFactory;
import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.GiveawayPolicyFactory;
import christmas.order.domain.Order;
import java.time.LocalDate;

public enum EventFactory {
    CHRISTMAS(new DiscountEvent(
            "크리스마스 디데이 할인",
            Constants.DURING_CHRISTMAS,
            DatePolicyFactory.EVERYDAY.get(),
            DiscountPolicyFactory.ELAPSED.get())),
    WEEKDAY(new DiscountEvent(
            "평일 할인",
            Constants.DURING_DECEMBER,
            DatePolicyFactory.WEEKDAY.get(),
            DiscountPolicyFactory.DESSERT.get())),
    WEEKEND(new DiscountEvent(
            "주말 할인",
            Constants.DURING_DECEMBER,
            DatePolicyFactory.WEEKEND.get(),
            DiscountPolicyFactory.MAIN.get())),
    SPECIAL(new DiscountEvent(
            "특별 할인",
            Constants.DURING_DECEMBER,
            DatePolicyFactory.SPECIAL.get(),
            DiscountPolicyFactory.SPECIAL.get())),
    GIVEAWAY(new GiveawayEvent(
            "증정 이벤트",
            Constants.DURING_DECEMBER,
            GiveawayPolicyFactory.CHAMPAGNE.get(),
            Constants.SILGE_CHAMPAGNE_GIVEAWAY));

    private final Event event;

    EventFactory(Event event) {
        this.event = event;
    }

    public boolean isAppliable(Order order) {
        return event.isAppliable(order);
    }

    public static class Constants {
        public static final EventPeriod DURING_CHRISTMAS = new EventPeriod(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));
        public static final EventPeriod DURING_DECEMBER = new EventPeriod(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31));
        public static final Giveaway SILGE_CHAMPAGNE_GIVEAWAY = new Giveaway(MenuFactory.CHAMPAGNE.get(), 1);
    }
}