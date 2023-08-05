package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderImpact extends AttackSkill {
    public BeholderImpact() {
        this.setName("비홀더 임팩트");
        this.setDamage(260.0);
        this.setAttackCount(6L);
        this.setCooldown(20.0);
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(3000L);
        this.setInterval(270L);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);       // 코어강화
        this.addFinalDamage(1.6);
        this.addIgnoreDefenseList(20L);
    }
}
