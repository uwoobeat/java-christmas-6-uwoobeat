package christmas.event.domain;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuFactory;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventTest {

    List<OrderLine> orderLines;
    LocalDate orderDate;

    @BeforeEach
    void setUp() {
        Menu soup = MenuFactory.MUSHROOM_SOUP.get();
        Menu tbone = MenuFactory.TBONE_STEAK.get();

        OrderLine soupOrderLine = new OrderLine(soup, 1);
        OrderLine tboneOrderLine = new OrderLine(tbone, 1);

        orderLines = List.of(soupOrderLine, tboneOrderLine);

        orderDate = LocalDate.of(2023, 12, 15);
    }

    @DisplayName("이벤트 기간 외 주문은 이벤트를 적용할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"2023-11-30", "2023-12-26"})
    void isNotAppliableOutsideEventPeriod(LocalDate inputDate) {
        Order order = new Order(orderLines, inputDate);

        // 이벤트 기간 : 2023-12-01 ~ 2023-12-25
        assertThat(EventFactory.CHRISTMAS.isAppliable(order))
                .isFalse();
    }

    @DisplayName("이벤트 기간 내 주문은 이벤트를 적용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"2023-12-01", "2023-12-25"})
    void isAppliableWithinEventPeriod(LocalDate inputDate) {
        Order order = new Order(orderLines, inputDate);

        assertThat(EventFactory.CHRISTMAS.isAppliable(order))
                .isTrue();
    }

    @DisplayName("10000원 이상 주문하지 않으면 이벤트를 적용할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void isNotAppliableUnderMinimumOrderAmount(int inputQuantity) {
        // 아이스크림은 개당 5000원
        OrderLine inputOrderLine = new OrderLine(MenuFactory.ICE_CREAM.get(), inputQuantity);
        Order order = new Order(List.of(inputOrderLine), orderDate);

        assertThat(EventFactory.CHRISTMAS.isAppliable(order))
                .isFalse();
    }

    @DisplayName("10000원 이상 주문하면 이벤트를 적용할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void isAppliableOverMinimumOrderAmount(int inputQuantity) {
        OrderLine inputOrderLine = new OrderLine(MenuFactory.ICE_CREAM.get(), inputQuantity);
        Order order = new Order(List.of(inputOrderLine), orderDate);

        assertThat(EventFactory.CHRISTMAS.isAppliable(order))
                .isTrue();
    }
}
