package christmas.event.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import christmas.common.domain.MenuFactory;
import christmas.common.domain.Money;
import christmas.datepolicy.domain.DatePolicyFactory;
import christmas.discountpolicy.domain.DiscountPolicyFactory;
import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.GiveawayPolicyFactory;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventsTest {

    Events applied;

    @BeforeEach
    void setUp() {
        List<Event> events = List.of(
                new DiscountEvent(
                        "테스트 할인 이벤트",
                        EventFactory.Constants.DURING_CHRISTMAS,
                        DatePolicyFactory.EVERYDAY.get(),
                        DiscountPolicyFactory.MAIN.get()  // 메인메뉴 개당 2023원씩 할인
                ),
                new GiveawayEvent(
                        "테스트 증정 이벤트",
                        EventFactory.Constants.DURING_CHRISTMAS,
                        GiveawayPolicyFactory.CHAMPAGNE.get(), // 샴페인 1병 증정
                        EventFactory.Constants.SINGLE_CHAMPAGNE_GIVEAWAY // 12만원 이상 주문시
                )
        );

        Order order = new Order(
                List.of(
                        new OrderLine(MenuFactory.TBONE_STEAK.get(), 3),  // 메인메뉴, 55000원
                        new OrderLine(MenuFactory.CHAMPAGNE.get(), 1)  // 음료, 25000원
                ),
                LocalDate.of(2023, 12, 15)
        );

        applied = Events.from(events, order);
    }

    @DisplayName("적용 이벤트 목록에서 증정품 목록을 조회할 수 있다.")
    @Test
    void getGiveways() {
        // 샴페인 1병 증정
        assertThat(applied.getGiveaways().getGiveaways())
                .containsExactly(new Giveaway(MenuFactory.CHAMPAGNE.get(), 1));
    }

    @DisplayName("적용 이벤트 목록에서 총할인금액을 조회할 수 있다.")
    @Test
    void getDiscountAmount() {
        // 메인메뉴 3개에 2023원씩 할인 = 6069원
        assertThat(applied.calculateDiscount())
                .isEqualTo(new Money(2023 * 3));
    }
}
