package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReactionDominationSOC extends AttackSkill {
    public ReactionDominationSOC() {
        this.setName("리액션:도미네이션(소울 오브 크리스탈)");
        this.setDamage(915.0);
        this.setAttackCount(5L);
        this.addFinalDamage(0.9);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
