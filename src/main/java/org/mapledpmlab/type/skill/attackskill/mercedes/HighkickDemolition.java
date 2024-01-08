package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HighkickDemolition extends AttackSkill {
    public HighkickDemolition() {
        this.setName("하이킥 데몰리션");
        this.setAttackCount(6L);
        this.setDamage(105.0 + 197);
        this.setDelayByAttackSpeed(660L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
