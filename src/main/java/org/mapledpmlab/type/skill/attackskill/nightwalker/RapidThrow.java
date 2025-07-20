package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrow extends AttackSkill implements DarkAttack {
    public RapidThrow() {
        this.setName("래피드 스로우");
        this.setAttackCount(5L);
        this.setDamage(715.0);
        this.setDelay(2160L);
        this.setDotDuration(2160L);
        this.setInterval(60L);
        this.setLimitAttackCount(36L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new RapidThrowEnd());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
