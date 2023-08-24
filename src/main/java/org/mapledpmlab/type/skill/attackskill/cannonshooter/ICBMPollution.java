package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ICBMPollution extends AttackSkill {
    public ICBMPollution() {
        this.setName("ICBM(오염 지역)");
        this.setDamage(1100.0);
        this.setAttackCount(1L);
        this.setDotDuration(15000L);
        this.setInterval(500L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
