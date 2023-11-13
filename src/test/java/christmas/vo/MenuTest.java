package christmas.vo;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.common.domain.Menu;
import christmas.common.domain.MenuType;
import christmas.common.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("메뉴 정보들이 같다면 같은 메뉴이다.")
    @Test
    void equals() {
        Menu menu = new Menu("양송이수프", MenuType.MAIN, new Money(10000));
        Menu sameMenu = new Menu("양송이수프", MenuType.MAIN, new Money(10000));

        assertThat(menu).isEqualTo(sameMenu);
    }
}
