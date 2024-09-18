package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment2 extends AttackSkill {
    public DivinePunishment2() {
        this.setName("디바인 퍼니시먼트(2스택)");
        this.setDamage(715.0);
        this.setAttackCount(10L);
        this.setDelay(2400L + 120);
        this.setDotDuration(2400L);
        this.setInterval(240L);
        this.setLimitAttackCount(10L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
