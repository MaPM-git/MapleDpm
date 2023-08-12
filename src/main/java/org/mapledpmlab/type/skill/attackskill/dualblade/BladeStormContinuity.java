package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeStormContinuity extends AttackSkill {
    public BladeStormContinuity() {
        this.setName("블레이드 스톰(연속 공격)");
        this.setDamage(960.0);
        this.setAttackCount(5L);
        this.setDotDuration(5000L);
        this.setInterval(119L);
        this.setLimitAttackCount(42L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setRelatedSkill(new BladeStormDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
