package christmas.common.exception;

public enum ErrorCode {
    MONEY_INVALID("유효하지 않은 금액입니다."),
    QUANTITY_INVALID("유효하지 않은 수량입니다."),
    ORDER_ALL_BEVERAGE("음료만 주문할 수 없습니다."),
    ORDER_MENU_DUPLICATE("메뉴는 중복해서 주문할 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
