package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReturningHatred extends AttackSkill {
    public ReturningHatred() {
        this.setName("돌아오는 증오");
        this.setDamage(370.0 + 113 + 480);
        this.setAttackCount(6L);
        this.setCooldown(12.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(500L);
    }
}
