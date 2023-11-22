package christmas.order.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class OrderEmptyException extends ChristmasArgumentException {

    public OrderEmptyException() {
        super(ErrorCode.EMPTY_ORDER.getMessage());
    }
}
