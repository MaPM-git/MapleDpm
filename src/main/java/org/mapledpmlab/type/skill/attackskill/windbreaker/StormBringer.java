package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StormBringer extends AttackSkill {
    public StormBringer() {
        this.setName("스톰브링어");
        this.setAttackCount(1L);
        this.setDamage(640.0);
        this.setProp(45L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
