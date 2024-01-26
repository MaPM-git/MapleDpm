package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment extends AttackSkill {
    public DivinePunishment() {
        this.setName("디바인 퍼니시먼트");
        this.setDamage(535.0);
        this.setAttackCount(10L);
        this.setDelay(1020L * 9 + 120);
        this.setDotDuration(10000L);
        this.setInterval(204L);
        this.setLimitAttackCount(45L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
