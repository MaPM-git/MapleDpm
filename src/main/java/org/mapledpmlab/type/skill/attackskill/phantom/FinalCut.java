package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalCut extends AttackSkill {
    public FinalCut() {
        this.setName("파이널 컷");
        this.setAttackCount(1L);
        this.setDamage(2020.0);
        this.setDelayByAttackSpeed(180L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
