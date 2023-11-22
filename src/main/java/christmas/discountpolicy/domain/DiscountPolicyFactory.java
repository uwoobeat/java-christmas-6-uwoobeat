package christmas.discountpolicy.domain;

import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import java.time.LocalDate;

public enum DiscountPolicyFactory {
    ELAPSED(new ElapsedDayDiscountPolicy(Constants.ELAPSED_START_DATE, Constants.ELAPSED_DISCOUNT_BASE,
            Constants.ELAPSED_DISCOUNT_STEP)),
    DESSERT(new MenuTypeDiscountPolicy(MenuType.DESSERT, Constants.DISCOUNT_DISCOUNT_UNIT)),
    MAIN(new MenuTypeDiscountPolicy(MenuType.MAIN, Constants.MAIN_DISCOUNT_UNIT)),
    SPECIAL(new FixedDiscountPolicy(Constants.SPECIAL_DISCOUNT_AMOUNT));

    private final DiscountPolicy discountPolicy;

    DiscountPolicyFactory(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public DiscountPolicy get() {
        return discountPolicy;
    }

    public static class Constants {
        public static final LocalDate ELAPSED_START_DATE = LocalDate.of(2023, 12, 1);
        public static final Money ELAPSED_DISCOUNT_BASE = new Money(1000);
        public static final Money ELAPSED_DISCOUNT_STEP = new Money(100);
        public static final Money DISCOUNT_DISCOUNT_UNIT = new Money(2023);
        public static final Money MAIN_DISCOUNT_UNIT = new Money(2023);
        public static final Money SPECIAL_DISCOUNT_AMOUNT = new Money(1000);
    }
}
