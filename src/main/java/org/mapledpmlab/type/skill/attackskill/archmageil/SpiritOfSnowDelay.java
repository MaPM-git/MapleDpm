package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritOfSnowDelay extends AttackSkill {
    public SpiritOfSnowDelay() {
        this.setName("스피릿 오브 스노우");
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(120.0);
    }
}
