package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbyssalLightning extends AttackSkill {
    public AbyssalLightning() {
        this.setName("어비셜 라이트닝");
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(180.0);
        this.setApplyServerLag(true);
    }
}
