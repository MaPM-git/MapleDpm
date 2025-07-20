package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeStormKeydown extends AttackSkill {
    public BladeStormKeydown() {
        this.setName("블레이드 스톰(연속 공격)");
        this.setDamage(570.0);
        this.setAttackCount(14L);
        this.setDelay(1650L);
        this.setDotDuration(1650L);
        this.setInterval(50L);
        this.setLimitAttackCount(33L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setRelatedSkill(new BladeStormAfterDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
