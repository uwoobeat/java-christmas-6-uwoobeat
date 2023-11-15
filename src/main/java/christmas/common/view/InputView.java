package christmas.common.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.domain.Menu;
import christmas.common.domain.MenuFactory;
import christmas.common.exception.ChristmasArgumentException;
import christmas.order.domain.OrderLine;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public LocalDate getReservationDate() {
        while (true) {
            try {
                String input = Console.readLine();
                int resertationDay = Integer.parseInt(input);
                return LocalDate.of(2023, 12, resertationDay);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (ChristmasArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public List<OrderLine> getOrderLines() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] orderLineInputs = input.split(",");
                return getOrderLines(orderLineInputs);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            } catch (ChristmasArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
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
}
