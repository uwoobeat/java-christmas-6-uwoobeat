package christmas.common.domain;

import christmas.common.domain.exception.NoSuchMenuException;
import java.util.stream.Stream;

public enum MenuFactory {
    MUSHROOM_SOUP(new Menu("양송이수프", MenuType.APPETIZER, new Money(6000))),
    TAPAS(new Menu("타파스", MenuType.APPETIZER, new Money(5500))),
    CAESAR_SALAD(new Menu("시저샐러드", MenuType.APPETIZER, new Money(8000))),

    TBONE_STEAK(new Menu("티본스테이크", MenuType.MAIN, new Money(55000))),
    BBQ_RIB(new Menu("바비큐립", MenuType.MAIN, new Money(54000))),
    SEAFOOD_PASTA(new Menu("해산물파스타", MenuType.MAIN, new Money(35000))),
    CHRISTMAS_PASTA(new Menu("크리스마스파스타", MenuType.MAIN, new Money(25000))),

    CHOCOLATE_CAKE(new Menu("초코케이크", MenuType.DESSERT, new Money(15000))),
    ICE_CREAM(new Menu("아이스크림", MenuType.DESSERT, new Money(5000))),

    ZERO_COLA(new Menu("제로콜라", MenuType.BEVERAGE, new Money(3000))),
    RED_WINE(new Menu("레드와인", MenuType.BEVERAGE, new Money(60000))),
    CHAMPAGNE(new Menu("샴페인", MenuType.BEVERAGE, new Money(25000)));

    private final Menu menu;

    MenuFactory(Menu menu) {
        this.menu = menu;
    }

    public Menu get() {
        return menu;
    }

    public static Menu fromName(String name) {
        return Stream.of(values())
                .filter(menuFactory -> menuFactory.menu.name().equals(name))
                .map(menuFactory -> menuFactory.menu)
                .findFirst()
                .orElseThrow(NoSuchMenuException::new);
    }
}
