package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildGrenade1 extends AttackSkill {
    public WildGrenade1() {
        this.setName("와일드 그레네이드 : 스파크(1스택)");
        this.setDotDuration(500L);
        this.setLimitAttackCount(1L);
        this.setInterval(500L);
        this.setDamage(1820.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setCooldown(10.0);
        this.setApplyCooldownReduction(false);
    }
}
