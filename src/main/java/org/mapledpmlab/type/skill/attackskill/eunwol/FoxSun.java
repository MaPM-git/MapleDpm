package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxSun extends AttackSkill {
    public FoxSun() {
        this.setName("여우볕");
        this.setDamage(385.0);
        this.setAttackCount(10L);
        this.setDotDuration(30000L);
        this.setInterval(180L);
        this.setLimitAttackCount(60L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
