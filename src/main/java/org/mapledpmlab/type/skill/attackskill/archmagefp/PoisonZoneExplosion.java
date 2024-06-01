package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonZoneExplosion extends AttackSkill {
    public PoisonZoneExplosion() {
        this.setName("포이즌 리젼(폭발)");
        this.setDamage(200.0);
        this.setAttackCount(4L);
        this.setCooldown(0.9);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
