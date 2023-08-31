package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadlyCharge extends AttackSkill {
    public DeadlyCharge() {
        this.setName("데들리 차지");
        this.setApplyFinalAttack(true);
        this.setAttackCount(10L);
        this.setDamage(825.0);
        this.setCooldown(15.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
