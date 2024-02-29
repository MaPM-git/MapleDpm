package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoBreath extends AttackSkill {
    public InfernoBreath() {
        this.setName("인퍼널 브레스");
        this.setDamage(304.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(1020L);
        this.setCooldown(20.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new InfernoBreathDot());
        this.setApplyReuse(true);
    }
}
