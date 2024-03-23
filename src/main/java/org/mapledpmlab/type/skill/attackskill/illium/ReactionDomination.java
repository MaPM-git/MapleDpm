package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReactionDomination extends AttackSkill {
    public ReactionDomination() {
        this.setName("리액션:도미네이션");
        this.setDamage(915.0);
        this.setAttackCount(5L);
        this.setCooldown(4.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
