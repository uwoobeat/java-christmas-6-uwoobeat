package christmas.order.domain;

import christmas.common.domain.MenuType;
import christmas.order.exception.OrderAllBeverageException;
import java.time.LocalDate;
import java.util.List;

public class Order {
    List<OrderLine> orderLines;
    LocalDate orderDate;

    public Order(List<OrderLine> orderLines, LocalDate orderDate) {
        validateMenuType(orderLines);
        this.orderLines = orderLines;
        this.orderDate = orderDate;
    }

    private void validateMenuType(List<OrderLine> orderLines) {
        if (checkAllOrdersBeverage(orderLines)) {
            throw new OrderAllBeverageException();
        }
    }

    private boolean checkAllOrdersBeverage(List<OrderLine> orderLines) {
        return orderLines.stream()
                .allMatch(orderLine -> orderLine.menu().type().equals(MenuType.BEVERAGE));
    }
}
