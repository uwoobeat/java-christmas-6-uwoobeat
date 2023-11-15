package christmas.common.domain.exception;

import christmas.common.exception.ChristmasStateException;
import christmas.common.exception.ErrorCode;

public class NoSuchMenuException extends ChristmasStateException {

    public NoSuchMenuException() {
        super(ErrorCode.NO_SUCH_MENU.getMessage());
    }
}
