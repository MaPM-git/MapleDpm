package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeStormFirst extends AttackSkill {
    public BladeStormFirst() {
        this.setName("블레이드 스톰(첫타)");
        this.setDamage(1270.0);
        this.setAttackCount(7L);
        this.setCooldown(90.0);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setRelatedSkill(new BladeStormContinuity());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
