package christmas.order.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class OrderMaxQuantityException extends ChristmasArgumentException {

    public OrderMaxQuantityException() {
        super(ErrorCode.ORDER_MAX_QUANTITY.getMessage());
    }
}
