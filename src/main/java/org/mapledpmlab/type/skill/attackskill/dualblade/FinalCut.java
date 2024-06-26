package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalCut extends AttackSkill {
    public FinalCut() {
        this.setName("파이널 컷");
        this.setAttackCount(2L);
        this.setDamage(2020.0);
        this.setDelayByAttackSpeed(180L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
