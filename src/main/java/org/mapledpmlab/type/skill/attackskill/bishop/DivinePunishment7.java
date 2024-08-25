package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment7 extends AttackSkill {
    public DivinePunishment7() {
        this.setName("디바인 퍼니시먼트(7스택)");
        this.setDamage(535.0);
        this.setAttackCount(10L);
        this.setDelay(1200L * 7 + 120);
        this.setDotDuration(8400L);
        this.setInterval(240L);
        this.setLimitAttackCount(35L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
