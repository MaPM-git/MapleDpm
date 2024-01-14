package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderDominant extends AttackSkill {
    public BeholderDominant() {
        this.setName("비홀더 도미넌트");
        this.setDamage(210.0);
        this.setAttackCount(1L);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setInterval(10000L);
    }
}
