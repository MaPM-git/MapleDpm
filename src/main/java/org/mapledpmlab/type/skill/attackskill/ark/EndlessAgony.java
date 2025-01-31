package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessAgony extends AttackSkill {
    public EndlessAgony() {
        this.setName("끝없는 고통");
        this.setDamage(576.0);
        this.setAttackCount(3L);
        this.setDelay(2700L);
        this.setDotDuration(2700L);
        this.setInterval(180L);
        this.setLimitAttackCount(15L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new EndlessAgonyFinish());
    }
}
