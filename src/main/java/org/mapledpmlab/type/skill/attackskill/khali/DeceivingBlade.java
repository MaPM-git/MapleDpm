package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeceivingBlade extends AttackSkill {
    public DeceivingBlade() {
        this.setName("디시빙 블레이드");
        this.setDamage(610.0);
        this.setAttackCount(2L);
        this.setCooldown(0.5);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(240L);
    }
}
