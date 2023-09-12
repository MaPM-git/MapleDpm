package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrowEnd extends AttackSkill {
    public RapidThrowEnd() {
        this.setName("래피드 스로우(막타)");
        this.setAttackCount(1L);
        this.setDamage(1870.0);
        this.setDotDuration(480L);
        this.setInterval(18L);
        this.setLimitAttackCount(26L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new RapidThrowEndDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
