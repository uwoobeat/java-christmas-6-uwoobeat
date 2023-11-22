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

class FixedDiscountPolicyTest {

    Order order;

    @BeforeEach
    void setUp() {
        Menu soup = MenuFactory.MUSHROOM_SOUP.get();
        Menu tbone = MenuFactory.TBONE_STEAK.get();

        OrderLine soupOrderLine = new OrderLine(soup, 1);
        OrderLine tboneOrderLine = new OrderLine(tbone, 1);

        List<OrderLine> orderLines = List.of(soupOrderLine, tboneOrderLine);
        LocalDate orderDate = LocalDate.of(2023, 11, 14);

        order = new Order(orderLines, orderDate);
    }

    @DisplayName("할인 금액은 초기 설정 금액과 같다.")
    @Test
    void discount() {
        Money discountAmount = new Money(1000);
        FixedDiscountPolicy policy = new FixedDiscountPolicy(discountAmount);

        assertThat(policy.discount(order))
                .isEqualTo(new Money(1000));
    }
}
