package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MemoryOfRootFinish extends AttackSkill {
    public MemoryOfRootFinish() {
        this.setName("근원의 기억(폭발)");
        this.setDamage(1815.0);
        this.setAttackCount(12L);
        this.setDelay(1110L);
        this.setDotDuration(1110L);
        this.setInterval(150L);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
