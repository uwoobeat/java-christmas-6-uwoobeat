package christmas.vo;

public record Menu(
        String name,
        MenuType type,
        Money price
) {
}
