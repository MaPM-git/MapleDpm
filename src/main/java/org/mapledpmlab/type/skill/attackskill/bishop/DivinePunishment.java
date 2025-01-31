package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment extends AttackSkill {
    public DivinePunishment() {
        this.setName("디바인 퍼니시먼트(5스택)");
        this.setDamage(715.0);
        this.setAttackCount(10L);
        this.setDelay(6000L + 120);
        this.setDotDuration(6000L);
        this.setInterval(240L);
        this.setLimitAttackCount(25L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
