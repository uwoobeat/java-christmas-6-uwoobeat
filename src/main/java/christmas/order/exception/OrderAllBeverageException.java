package christmas.order.exception;

import christmas.common.exception.ChristmasArgumentException;
import christmas.common.exception.ErrorCode;

public class OrderAllBeverageException extends ChristmasArgumentException {
    public OrderAllBeverageException() {
        super(ErrorCode.ORDER_ALL_BEVERAGE.getMessage());
    }
}
