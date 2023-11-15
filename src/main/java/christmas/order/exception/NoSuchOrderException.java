package christmas.order.exception;

import christmas.common.exception.ChristmasStateException;
import christmas.common.exception.ErrorCode;

public class NoSuchOrderException extends ChristmasStateException {

    public NoSuchOrderException() {
        super(ErrorCode.NO_SUCH_ORDER.getMessage());
    }
}
