package se.fk.party.common.domain;

import java.util.Objects;

public enum RelationType {
    MARRIED(1), PARTNER(2), PARTNER_WITH_CHILDREN(3), CHILD(4), WIDOW_WIDOWER(5), OTHER(9), UNKNOWN(0);
    private final Integer code;

    RelationType(Integer code) {
        this.code = Objects.requireNonNull(code, "code can't be null");
    }

    public static RelationType relationType(Integer code) {
        return switch (code) {
            case 1 -> MARRIED;
            case 2 -> PARTNER;
            case 3 -> PARTNER_WITH_CHILDREN;
            case 4 -> CHILD;
            case 5 -> WIDOW_WIDOWER;
            case 9 -> OTHER;
            default -> UNKNOWN;
        };
    }
}
