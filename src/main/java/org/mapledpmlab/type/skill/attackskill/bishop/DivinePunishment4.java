package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment4 extends AttackSkill {
    public DivinePunishment4() {
        this.setName("디바인 퍼니시먼트(4스택)");
        this.setDamage(715.0);
        this.setAttackCount(10L);
        this.setDelay(4800L + 120);
        this.setDotDuration(4800L);
        this.setInterval(240L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
