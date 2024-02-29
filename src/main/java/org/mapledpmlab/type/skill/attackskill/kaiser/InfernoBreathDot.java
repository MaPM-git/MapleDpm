package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoBreathDot extends AttackSkill {
    public InfernoBreathDot() {
        this.setName("인퍼널 브레스");
        this.setDamage(203.0);
        this.setAttackCount(1L);
        this.setDotDuration(20000L);
        this.setInterval(1200L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
