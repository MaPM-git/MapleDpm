package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BurningBreakerExplosion extends AttackSkill {
    public BurningBreakerExplosion() {
        this.setName("버닝 브레이커(폭발)");
        this.setAttackCount(90L);
        this.setDamage(2640.0);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
        this.setDelayByAttackSpeed(2940L);
    }
}
