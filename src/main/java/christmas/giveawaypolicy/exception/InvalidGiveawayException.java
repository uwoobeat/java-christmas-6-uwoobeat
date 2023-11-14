package christmas.giveawaypolicy.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class InvalidGiveawayException extends ChristmasArgumentException {

    public InvalidGiveawayException() {
        super(ErrorCode.GIVEAWAY_INVALID.getMessage());
    }
}
