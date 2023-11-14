package christmas.discountpolicy.domain;

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

class ElapsedDayDiscountPolicyTest {

    Order order;

    @BeforeEach
    void setUp() {
        Menu soup = MenuFactory.MUSHROOM_SOUP.getMenu();
        Menu tbone = MenuFactory.TBONE_STEAK.getMenu();

        OrderLine soupOrderLine = new OrderLine(soup, 1);
        OrderLine tboneOrderLine = new OrderLine(tbone, 1);

        List<OrderLine> orderLines = List.of(soupOrderLine, tboneOrderLine);
        LocalDate orderDate = LocalDate.of(2023, 11, 14);

        order = new Order(orderLines, orderDate);
    }

    @DisplayName("할인 금액 = (초기 할인금액) + (단위 할인금액) * (주문일 기준 경과일수)")
    @Test
    void discount() {
        LocalDate targetDate = LocalDate.of(2023, 11, 10);
        Money discountBase = new Money(1000);
        Money discountStep = new Money(100);
        ElapsedDayDiscountPolicy policy = new ElapsedDayDiscountPolicy(targetDate, discountBase, discountStep);

        assertThat(policy.discount(order))
                .isEqualTo(new Money(1400));
    }
}
