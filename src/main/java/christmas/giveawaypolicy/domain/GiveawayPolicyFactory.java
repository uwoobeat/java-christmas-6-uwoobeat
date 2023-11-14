package christmas.giveawaypolicy.domain;

import christmas.common.domain.Money;

public enum GiveawayPolicyFactory {
    CHAMPAGNE(new GiveawayPolicy(new Money(120000)));

    private final GiveawayPolicy giveawayPolicy;

    GiveawayPolicyFactory(GiveawayPolicy giveawayPolicy) {
        this.giveawayPolicy = giveawayPolicy;
    }

    public GiveawayPolicy get() {
        return giveawayPolicy;
    }
}
