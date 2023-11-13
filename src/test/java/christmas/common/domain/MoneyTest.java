package christmas.common.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.common.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("금액이 음수이면 예외가 발생한다.")
    @Test
    void createByNegativeAmount() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(InvalidMoneyException.class);
    }

    @DisplayName("금액이 같다면 같은 돈이다.")
    @Test
    void equals() {
        Money money = new Money(1000);
        Money target = new Money(1000);

        assertThat(money).isEqualTo(target);
    }

    @DisplayName("금액을 더할 수 있다.")
    @Test
    void add() {
        Money money = new Money(1000);
        Money target = new Money(500);

        Money result = money.add(target);

        assertThat(result).isEqualTo(new Money(1500));
    }

    @DisplayName("금액을 뺄 수 있다.")
    @Test
    void subtract() {
        Money money = new Money(1000);
        Money target = new Money(500);

        Money result = money.subtract(target);

        assertThat(result).isEqualTo(new Money(500));
    }

    @DisplayName("금액을 뺸 결과가 음수이면 예외가 발생한다.")
    @Test
    void subtractByNegativeAmount() {
        Money money = new Money(1000);
        Money target = new Money(1500);

        assertThatThrownBy(() -> money.subtract(target))
                .isInstanceOf(InvalidMoneyException.class);
    }

    @DisplayName("금액을 대상 정수와 곱할 수 있다.")
    @Test
    void multiply() {
        Money money = new Money(1000);
        int target = 2;

        Money result = money.multiply(target);

        assertThat(result).isEqualTo(new Money(2000));
    }
}
