package christmas.common.manager;

import christmas.common.view.InputView;
import christmas.common.view.OutputView;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import christmas.reservation.domain.Reservation;
import java.time.LocalDate;
import java.util.List;

public class EventPlanner {

    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printWelcomeMessage();

        outputView.printReservationRequestMessage();
        LocalDate reservationDate = inputView.getReservationDate();

        outputView.printOrderRequestMessage();
        List<OrderLine> orderLines = inputView.getOrderLines();

        Order order = new Order(orderLines, reservationDate);
        Reservation reservation = Reservation.of(order);

        outputView.printReservation(reservation);
    }
}
