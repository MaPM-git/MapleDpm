package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReactionSpectrum extends AttackSkill {
    public ReactionSpectrum() {
        this.setName("리액션:스펙트럼");
        this.setDamage(3483.0);
        this.setAttackCount(6L);
        this.setAddDamage(20L);
        this.setCooldown(1.0);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
