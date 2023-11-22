package christmas.common.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴 정보들이 같다면 같은 메뉴이다.")
    @Test
    void equals() {
        Menu menu = new Menu("테스트 메뉴", MenuType.BEVERAGE, new Money(1000));
        Menu sameMenu = new Menu("테스트 메뉴", MenuType.BEVERAGE, new Money(1000));

        assertThat(menu).isEqualTo(sameMenu);
    }
}
