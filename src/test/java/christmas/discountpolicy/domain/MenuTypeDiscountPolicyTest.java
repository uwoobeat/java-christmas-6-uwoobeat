package christmas.discountpolicy.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuFactory;
import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTypeDiscountPolicyTest {

    Order order;

    @BeforeEach
    void setUp() {
        Menu soup = MenuFactory.MUSHROOM_SOUP.get();  // appetizer
        Menu tbone = MenuFactory.TBONE_STEAK.get();  // main
        Menu choco = MenuFactory.CHOCOLATE_CAKE.get();  // dessert

        OrderLine soupOrderLine = new OrderLine(soup, 1);
        OrderLine tboneOrderLine = new OrderLine(tbone, 2);
        OrderLine chocoOrderLine = new OrderLine(choco, 3);

        List<OrderLine> orderLines = List.of(soupOrderLine, tboneOrderLine, chocoOrderLine);
        LocalDate orderDate = LocalDate.of(2023, 11, 14);

        order = new Order(orderLines, orderDate);
    }

    @DisplayName("할인금액 = (단위 할인금액) * (기준 메뉴타입의 총 주문수량)")
    @Test
    void discount() {
        Money discountUnit = new Money(1000);
        MenuTypeDiscountPolicy policy = new MenuTypeDiscountPolicy(MenuType.MAIN, discountUnit);

        assertThat(policy.discount(order))
                .isEqualTo(new Money(2000));
    }

    @DisplayName("해당 메뉴타입의 주문수량이 0개라면 할인금액은 0원이다.")
    @Test
    void discountByZeroQuantity() {
        Money discountUnit = new Money(1000);
        MenuTypeDiscountPolicy policy = new MenuTypeDiscountPolicy(MenuType.BEVERAGE, discountUnit);

        assertThat(policy.discount(order))
                .isEqualTo(new Money(0));
    }
}
