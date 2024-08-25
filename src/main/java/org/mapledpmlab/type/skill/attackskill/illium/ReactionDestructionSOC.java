package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReactionDestructionSOC extends AttackSkill {
    public ReactionDestructionSOC() {
        this.setName("리액션:디스트럭션(소울 오브 크리스탈)");
        this.setDamage(1145.0);
        this.setAttackCount(6L);
        this.setAddDamage(20L);
        this.addFinalDamage(0.9);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
