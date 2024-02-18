package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightningGodSpearStrikeDot extends AttackSkill {
    public LightningGodSpearStrikeDot() {
        this.setName("뇌신창격(전격)");
        this.setAttackCount(7L);
        this.setDamage(440.0);
        this.setDotDuration(7000L);
        this.setInterval(1000L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
