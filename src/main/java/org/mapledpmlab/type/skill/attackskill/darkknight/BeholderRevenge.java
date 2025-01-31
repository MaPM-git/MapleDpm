package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderRevenge extends AttackSkill {
    public BeholderRevenge() {
        this.setName("비홀더스 리벤지");
        this.setDamage(148.0 + 37);
        this.setAttackCount(5L);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);
        this.addIgnoreDefenseList(20L);
    }
}
