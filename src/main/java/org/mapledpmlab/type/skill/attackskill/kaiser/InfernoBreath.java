package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoBreath extends AttackSkill {
    public InfernoBreath() {
        this.setName("인퍼널 브레스");
        this.setDamage(3180.0);
        this.setAttackCount(14L);
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(19.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
