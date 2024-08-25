package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonZoneExplosionSecond extends AttackSkill {
    public PoisonZoneExplosionSecond() {
        this.setName("포이즌 리젼(폭발 2타)");
        this.setDamage(200.0);
        this.setAttackCount(4L);
        this.setCooldown(1.5);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.addFinalDamage(0.4);
    }
}
