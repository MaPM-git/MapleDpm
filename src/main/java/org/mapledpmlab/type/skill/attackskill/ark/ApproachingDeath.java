package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ApproachingDeath extends AttackSkill {
    public ApproachingDeath() {
        this.setName("다가오는 죽음");
        this.setDamage(190.0 + 145 + 118 + 60);
        this.setAttackCount(2L);
        this.getMultiAttackInfo().add(500L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
