package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class PoisonZone extends DotAttackSkill {
    public PoisonZone() {
        this.setName("포이즌 리젼(도트)");
        this.setDamage(307.0);
        this.setAttackCount(1L);
        this.setDelayByAttackSpeed(810L);
        this.setCooldown(60.0);
        this.setInterval(1000L);
        this.setDotDuration(60000L);
    }
}
