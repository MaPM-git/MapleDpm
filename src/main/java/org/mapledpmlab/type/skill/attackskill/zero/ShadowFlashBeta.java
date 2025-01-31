package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowFlashBeta extends AttackSkill {
    public ShadowFlashBeta() {
        this.setName("쉐도우 플래시(베타)");
        this.setAttackCount(5L);
        this.setDamage(1860.0);
        this.setDelayByAttackSpeed(670L);
        this.setCooldown(40.0);
        //this.setDotDuration(40000L);
        //this.setInterval(70L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
