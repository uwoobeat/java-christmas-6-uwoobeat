package christmas.event.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class InvalidEventPeriodException extends ChristmasArgumentException {

    public InvalidEventPeriodException() {
        super(ErrorCode.EVENT_PERIOD_INVALID.getMessage());
    }
}
