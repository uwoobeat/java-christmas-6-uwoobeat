package christmas.common.view;

import christmas.badge.domain.Badge;
import christmas.common.domain.Money;
import christmas.event.domain.Event;
import christmas.event.domain.Events;
import christmas.giveawaypolicy.domain.Giveaway;
import christmas.giveawaypolicy.domain.Giveaways;
import christmas.order.domain.Order;
import christmas.order.domain.OrderLine;
import christmas.reservation.domain.Reservation;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OutputView {

    public static final String NONE_STRING = "없음";

    public void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printReservation(Reservation reservation) {
        printInfoMessage(reservation.getOrder().getOrderedAt().getDayOfMonth());
        printOrder(reservation.getOrder());
        printOrderedAmount(reservation.getMoneyInfo().orderedAmount());
        printGiveaways(reservation.getGiveaways());
        printAppliedEvents(reservation.getApplied());
        printBenefitAmount(reservation.getMoneyInfo().benefitAmount());
        printWillPaidAmount(reservation.getMoneyInfo().willPaidAmount());
        printBadge(reservation.getBadge());
    }

    private void printInfoMessage(int date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", date);
        System.out.println();
        System.out.println();
    }

    private void printOrder(Order order) {
        System.out.println("<주문 메뉴>");
        order.getOrderLines().forEach(this::printOrderLine);
        System.out.println();
    }

    private void printOrderLine(OrderLine line) {
        System.out.printf("%s %d개%n", line.menu().name(), line.quantity());
    }

    private void printMoney(Money money, boolean isNegative) {
        if (money.amount() == 0) {
            System.out.println("0원");
            return;
        }

        if (isNegative) {
            System.out.print("-");
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(decimalFormat.format(money.amount()) + "원");
    }

    private void printOrderedAmount(Money money) {
        System.out.println("<할인 전 총주문 금액>");
        printMoney(money, false);
        System.out.println();
    }

    private void printGiveaways(Giveaways giveaways) {
        System.out.println("<증정 메뉴>");

        if (giveaways.getGiveaways().isEmpty()) {
            printMessageWhenEmpty();
            return;
        }

        printGivewayWhenExists(giveaways.getGiveaways());

        System.out.println();
    }

    private void printGivewayWhenExists(List<Giveaway> giveaways) {
        giveaways.forEach(this::printGiveaway);
    }

    private void printGiveaway(Giveaway giveaway) {
        System.out.printf("%s %d개%n", giveaway.menu().name(), giveaway.quantity());
    }

    private void printAppliedEvents(Events applied) {
        System.out.println("<혜택 내역>");

        if (applied.getEventMap().isEmpty()) {
            printEventBenefitWhenExists(applied.getEventMap());
        }

        printMessageWhenEmpty();
    }

    private void printEventBenefitWhenExists(Map<Event, Money> eventMoneyMap) {
        eventMoneyMap.forEach(this::printEventBenefit);
    }

    private void printEventBenefit(Event event, Money money) {
        System.out.printf("%s: ", event.getName());
        printMoney(money, true);
    }

    private void printBenefitAmount(Money money) {
        System.out.println("<총혜택 금액>");
        printMoney(money, true);
        System.out.println();
    }

    private void printWillPaidAmount(Money money) {
        System.out.println("<할인 후 예상 결제 금액>");
        printMoney(money, false);
        System.out.println();
    }

    private void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        Optional.ofNullable(badge).ifPresentOrElse(
                this::printBadgeWhenExists,
                this::printMessageWhenEmpty
        );
    }

    private void printBadgeWhenExists(Badge badge) {
        System.out.println(badge.getName());
    }

    public void printReservationRequestMessage() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void printOrderRequestMessage() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    private void printMessageWhenEmpty() {
        System.out.println(NONE_STRING);
        System.out.println();
    }
}
