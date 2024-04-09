package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowFlashAlphaFinish extends AttackSkill {
    public ShadowFlashAlphaFinish() {
        this.setName("쉐도우 플래시(알파, 재사용)");
        this.setAttackCount(15L);
        this.setDamage(1145.0);
        this.setDelay(880L);
        this.setDotDuration(880L);
        this.setInterval(90L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
