package christmas.giveawaypolicy.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuFactory;
import christmas.common.domain.Money;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayPolicyTest {

    Order order;

    @BeforeEach
    void setUp() {
        Menu soup = MenuFactory.MUSHROOM_SOUP.get();
        Menu tbone = MenuFactory.TBONE_STEAK.get();

        OrderLine soupOrderLine = new OrderLine(soup, 1);
        OrderLine tboneOrderLine = new OrderLine(tbone, 1);

        List<OrderLine> orderLines = List.of(soupOrderLine, tboneOrderLine);
        LocalDate orderDate = LocalDate.of(2023, 11, 14);

        order = new Order(orderLines, orderDate);  // 총 주문금액 : 61,000원
    }

    @DisplayName("총주문금액이 기준금액보다 크거나 같다면 적용할 수 있다.")
    @Test
    void isAppliable() {
        GiveawayPolicy policy = new GiveawayPolicy(new Money(60000));

        assertThat(policy.isGiveable(order))
                .isTrue();
    }
}
