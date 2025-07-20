package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildGrenade4 extends AttackSkill {
    public WildGrenade4() {
        this.setName("와일드 그레네이드 : 스파크(4스택)");
        this.setDotDuration(2000L);
        this.setLimitAttackCount(4L);
        this.setInterval(500L);
        this.setDamage(1820.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setCooldown(40.0);
        this.setApplyCooldownReduction(false);
    }
}
