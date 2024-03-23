package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReactionDestruction extends AttackSkill {
    public ReactionDestruction() {
        this.setName("리액션:디스트럭션");
        this.setDamage(1145.0);
        this.setAttackCount(6L);
        this.setCooldown(4.0);
        this.setAddDamage(20L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(810L);
        this.setApplyReuse(true);
    }
}
