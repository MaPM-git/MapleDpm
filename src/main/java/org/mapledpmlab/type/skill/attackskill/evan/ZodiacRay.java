package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacRay extends AttackSkill {
    public ZodiacRay() {
        this.setName("조디악 레이");
        this.setDamage(1045.0);
        this.setAttackCount(8L);
        this.addIgnoreDefenseList(100L);
        this.setDotDuration(12000L);
        this.setInterval(150L);
        this.setLimitAttackCount(69L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
