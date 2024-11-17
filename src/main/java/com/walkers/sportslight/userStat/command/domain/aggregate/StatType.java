package com.walkers.sportslight.userStat.command.domain.aggregate;

public enum StatType {
    MUSCULAR_STRENGTH("muscularStrength"),
    MUSCULAR_ENDURANCE("muscularEndurance"),
    AGILITY("agility"),
    QUICKNESS("quickness"),
    BALANCE("balance"),
    FLEXIBILITY("flexibility"),
    USER_EXPERIENCE("userExperience"); // 유저 경험치의 카멜케이스 매핑

    private final String camelCase;

    StatType(String camelCase) {
        this.camelCase = camelCase;
    }

    public String getCamelCase() {
        return camelCase;
    }
}
