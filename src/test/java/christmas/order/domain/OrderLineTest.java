package christmas.order.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderLineTest {

    @DisplayName("주문내역의 주문수량이 1개 이상이 아니라면 예외가 발생한다.")
    @Test
    void createByInvalidQuantity() {
        Menu soup = new Menu("양송이수프", MenuType.MAIN, new Money(10000));

        assertThatThrownBy(() -> new OrderLine(soup, 0))
                .isInstanceOf(InvalidQuantityException.class);
    }

    @DisplayName("주문내역의 주문메뉴와 주문수량이 같다면 같은 주문내역이다.")
    @Test
    void equals() {
        Menu soup = new Menu("양송이수프", MenuType.MAIN, new Money(10000));
        OrderLine orderLine = new OrderLine(soup, 1);
        OrderLine sameOrderLine = new OrderLine(soup, 1);

        assertThat(orderLine).isEqualTo(sameOrderLine);
    }

    @DisplayName("주문내역의 주문금액은 주문메뉴의 가격과 주문수량을 곱한 금액이다.")
    @Test
    void calculateAmount() {
        Menu soup = new Menu("양송이수프", MenuType.MAIN, new Money(10000));
        OrderLine orderLine = new OrderLine(soup, 2);
        Money totalPrice = soup.price().multiply(2);

        assertThat(orderLine.calculatePrice()).isEqualTo(totalPrice);
    }
}
