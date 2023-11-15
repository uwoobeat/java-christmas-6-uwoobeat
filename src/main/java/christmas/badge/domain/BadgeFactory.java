package christmas.badge.domain;

import christmas.badgepolicy.domain.BadgePolicyFactory;
import christmas.reservation.domain.MoneyInfo;
import java.util.Optional;
import java.util.stream.Stream;

public enum BadgeFactory {
    SANTA(new Badge("산타", BadgePolicyFactory.SANTA.get())),
    TREE(new Badge("트리", BadgePolicyFactory.TREE.get())),
    STAR(new Badge("별", BadgePolicyFactory.STAR.get()));

    private final Badge badge;

    BadgeFactory(Badge badge) {
        this.badge = badge;
    }

