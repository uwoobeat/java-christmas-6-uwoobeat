package christmas.order.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import christmas.order.exception.OrderAllBeverageException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("주문의 주문내역들의 메뉴타입이 전부 음료라면 예외가 발생한다")
    @Test
    void createByAllBeverage() {
        Menu zeroCola = new Menu("제로콜라", MenuType.BEVERAGE, new Money(3000));
        Menu redWine = new Menu("레드와인", MenuType.BEVERAGE, new Money(60000));
        Menu champagne = new Menu("샴페인", MenuType.BEVERAGE, new Money(25000));

        OrderLine zeroColaOrderLine = new OrderLine(zeroCola, 1);
        OrderLine redWineOrderLine = new OrderLine(redWine, 1);
        OrderLine champagneOrderLine = new OrderLine(champagne, 1);

        List<OrderLine> orderLines = List.of(zeroColaOrderLine, redWineOrderLine, champagneOrderLine);
        LocalDate orderDate = LocalDate.of(2023, 11, 13);

        assertThatThrownBy(() -> new Order(orderLines, orderDate))
                .isInstanceOf(OrderAllBeverageException.class);
    }
}
