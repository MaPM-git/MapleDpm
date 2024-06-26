package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeStormFirst extends AttackSkill {
    public BladeStormFirst() {
        this.setName("블레이드 스톰(첫타)");
        this.setDamage(1270.0);
        this.setAttackCount(14L);
        this.setCooldown(90.0);
        this.setDelay(900L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setRelatedSkill(new BladeStormBeforeDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
