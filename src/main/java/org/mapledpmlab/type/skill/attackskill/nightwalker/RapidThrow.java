package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrow extends AttackSkill {
    public RapidThrow() {
        this.setName("래피드 스로우");
        this.setAttackCount(1L);
        this.setDamage(1045.0 + 290);   // 쉐도우 스피어
        this.setDotDuration(3000L);
        this.setInterval(18L);
        this.setCooldown(90.0);
        this.setLimitAttackCount(160L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new RapidThrowDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
