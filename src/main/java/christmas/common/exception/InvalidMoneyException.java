package christmas.common.exception;

public class InvalidMoneyException extends ChristmasArgumentException {

    public InvalidMoneyException() {
        super(ErrorCode.MONEY_INVALID.getMessage());
    }
}
