package christmas.order.domain;

import christmas.common.domain.MenuType;
import christmas.order.exception.OrderAllBeverageException;
import christmas.order.exception.OrderMenuDuplicateException;
import java.time.LocalDate;
import java.util.List;

public class Order {
    List<OrderLine> orderLines;
    LocalDate orderDate;

    public Order(List<OrderLine> orderLines, LocalDate orderDate) {
        validateMenuTypeDuplicate(orderLines);
        validateMenuTypeAllBeverage(orderLines);
        this.orderLines = orderLines;
        this.orderDate = orderDate;
    }

    private void validateMenuTypeDuplicate(List<OrderLine> orderLines) {
        if (hasDuplicateMenu(orderLines)) {
            throw new OrderMenuDuplicateException();
        }
    }

    private static boolean hasDuplicateMenu(List<OrderLine> orderLines) {
        return orderLines.stream().distinct().count() != orderLines.size();
    }

    private void validateMenuTypeAllBeverage(List<OrderLine> orderLines) {
        if (hasAllBeverageMenu(orderLines)) {
            throw new OrderAllBeverageException();
        }
    }

    private static boolean hasAllBeverageMenu(List<OrderLine> orderLines) {
        return orderLines.stream()
                .allMatch(line -> line.menu().type().equals(MenuType.BEVERAGE));
    }
}
