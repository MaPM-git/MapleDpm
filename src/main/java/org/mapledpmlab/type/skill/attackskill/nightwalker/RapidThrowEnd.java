package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidThrowEnd extends AttackSkill implements DarkAttack {
    public RapidThrowEnd() {
        this.setName("래피드 스로우(막타)");
        this.setAttackCount(13L);
        this.setDelay(630L);
        this.setDamage(1870.0);
        this.setDotDuration(630L);
        this.setInterval(315L);
        this.setLimitAttackCount(2L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
