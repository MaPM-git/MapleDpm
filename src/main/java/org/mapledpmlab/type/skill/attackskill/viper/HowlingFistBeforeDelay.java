package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingFistBeforeDelay extends AttackSkill {
    public HowlingFistBeforeDelay() {
        this.setName("하울링 피스트(선딜)");
        this.setDelay(480L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new HowlingFist());
    }
}
