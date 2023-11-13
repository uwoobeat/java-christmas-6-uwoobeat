package christmas.order.domain;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class InvalidQuantityException extends ChristmasArgumentException {
    public InvalidQuantityException() {
        super(ErrorCode.QUANTITY_INVALID.getMessage());
    }
}
