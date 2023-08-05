package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedQuiver extends AttackSkill {
    public AdvancedQuiver() {
        this.setName("어드밴스드 퀴버");
        this.setAttackCount(1L);
        this.setDamage(260.0);
        this.setProp(60L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
