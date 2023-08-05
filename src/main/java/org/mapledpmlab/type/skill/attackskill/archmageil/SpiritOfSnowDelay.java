package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritOfSnowDelay extends AttackSkill {
    public SpiritOfSnowDelay() {
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(120.0);
    }
}
