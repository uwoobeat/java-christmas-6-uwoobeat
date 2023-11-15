package christmas.order.domain;

import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import christmas.order.exception.OrderAllBeverageException;
import christmas.order.exception.OrderMaxQuantityException;
import christmas.order.exception.OrderMenuDuplicateException;
import java.time.LocalDate;
import java.util.List;

public class Order {
    public static final int MAX_QUANTITY = 20;
    List<OrderLine> orderLines;
    LocalDate orderedAt;

    public Order(List<OrderLine> orderLines, LocalDate orderedAt) {
        validateTotalQuantity(orderLines);
        validateMenuTypeDuplicate(orderLines);
        validateMenuTypeAllBeverage(orderLines);
        this.orderLines = orderLines;
        this.orderedAt = orderedAt;
    }

    private void validateTotalQuantity(List<OrderLine> orderLines) {
        if (hasProperTotalQuantity(orderLines)) {
            throw new OrderMaxQuantityException();
        }
    }

    private static boolean hasProperTotalQuantity(List<OrderLine> orderLines) {
        return orderLines.stream().mapToInt(OrderLine::quantity).sum() > MAX_QUANTITY;
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

    public LocalDate getOrderedAt() {
        return orderedAt;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public int countByType(MenuType menuType) {
        return orderLines.stream()
                .filter(line -> line.menu().type().equals(menuType))
                .mapToInt(OrderLine::quantity)
                .sum();
    }

    public Money calculateTotalAmount() {
        // TODO: 커스텀 예외 만들기
        return orderLines.stream()
                .map(OrderLine::calculatePrice)
                .reduce(Money::add)
                .orElseThrow(() -> new IllegalStateException("주문 항목이 없습니다."));
    }
}
