package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildGrenade extends AttackSkill {
    public WildGrenade() {
        this.setName("와일드 그레네이드");
        this.setDotDuration(4000L);
        this.setLimitAttackCount(8L);
        this.setInterval(500L);
        this.setDamage(1320.0);
        this.setAttackCount(6L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setCooldown(40.0);
    }
}
