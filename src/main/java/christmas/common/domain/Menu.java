package christmas.common.domain;

public record Menu(
        String name,
        MenuType type,
        Money price
) {
}
