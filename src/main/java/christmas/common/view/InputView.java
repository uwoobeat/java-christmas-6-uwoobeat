package christmas.common.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.domain.Menu;
import christmas.common.domain.MenuFactory;
import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ChristmasStateException;
import christmas.order.domain.OrderLine;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static final String INVALID_ORDER_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String INVALID_DATE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public LocalDate getReservationDate() {
        try {
            String input = Console.readLine();
            int resertationDay = Integer.parseInt(input);
            return LocalDate.of(2023, 12, resertationDay);
        } catch (NumberFormatException | DateTimeException ignored) {
            printErrorMessage(INVALID_DATE_MESSAGE);
            return getReservationDate();
        }
    }

    public List<OrderLine> getOrderLines() {
        try {
            String input = Console.readLine();
            String[] orderLineInputs = input.split(",");
            return getOrderLines(orderLineInputs);
        } catch (NumberFormatException | ChristmasStateException | ChristmasArgumentException ignored) {
            printErrorMessage(INVALID_ORDER_MESSAGE);
            return getOrderLines();
        }
    }

    private List<OrderLine> getOrderLines(String[] orderLineInputs) {
        List<OrderLine> orderLines = new ArrayList<>();

        for (String orderLineInput : orderLineInputs) {
            OrderLine orderLine = getOrderLine(orderLineInput);
            orderLines.add(orderLine);
        }

        return orderLines;
    }

    private OrderLine getOrderLine(String orderLineInput) {
        String[] orderLineInputSplit = orderLineInput.split("-");
        String menuName = orderLineInputSplit[0];
        Menu menu = MenuFactory.fromName(menuName);
        int quantity = Integer.parseInt(orderLineInputSplit[1]);
        return new OrderLine(menu, quantity);
    }

    private static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
