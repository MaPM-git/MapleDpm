package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FallingDust extends AttackSkill {
    public FallingDust() {
        this.setName("폴링 더스트");
        this.setDamage(910.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
        this.setApplyCooldownReduction(false);
    }
}
