package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment1 extends AttackSkill {
    public DivinePunishment1() {
        this.setName("디바인 퍼니시먼트(1스택)");
        this.setDamage(535.0);
        this.setAttackCount(10L);
        this.setDelay(1200L + 120);
        this.setDotDuration(1200L);
        this.setInterval(240L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
