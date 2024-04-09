package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowFlashBetaFinish extends AttackSkill {
    public ShadowFlashBetaFinish() {
        this.setName("쉐도우 플래시(베타, 재사용)");
        this.setAttackCount(12L);
        this.setDamage(1670.0);
        this.setDelay(880L);
        this.setDotDuration(880L);
        this.setInterval(90L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
