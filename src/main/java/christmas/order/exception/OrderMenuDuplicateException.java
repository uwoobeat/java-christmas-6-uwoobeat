package christmas.order.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class OrderMenuDuplicateException extends ChristmasArgumentException {

    public OrderMenuDuplicateException() {
        super(ErrorCode.ORDER_MENU_DUPLICATE.getMessage());
    }
}
