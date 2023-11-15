package christmas.common.exception;

public enum ErrorCode {
    MONEY_INVALID("유효하지 않은 금액입니다."),
    QUANTITY_INVALID("유효하지 않은 수량입니다."),
    ORDER_ALL_BEVERAGE("음료만 주문할 수 없습니다."),
    ORDER_MENU_DUPLICATE("메뉴는 중복해서 주문할 수 없습니다."),
    ORDER_MAX_QUANTITY("전체 주문 수량은 20개를 초과할 수 없습니다."),
    EVENT_PERIOD_INVALID("유효하지 않은 이벤트 기간입니다."),
    GIVEAWAY_INVALID("유효하지 않은 증정품입니다."),
    NO_SUCH_MENU("존재하지 않는 메뉴입니다."),
    NO_SUCH_ORDER("존재하지 않는 주문입니다."),
    EMPTY_ORDER("주문이 비어있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
