package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowFlashAlpha extends AttackSkill {
    public ShadowFlashAlpha() {
        this.setName("쉐도우 플래시(알파)");
        this.setAttackCount(6L);
        this.setDamage(1430.0);
        this.setDelay(880L);
        this.setCooldown(40.0);
        //this.setDotDuration(40000L);
        //this.setInterval(80L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
