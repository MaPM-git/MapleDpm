package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightningGodSpearStrike extends AttackSkill {
    public LightningGodSpearStrike() {
        this.setName("뇌신창격");
        this.setAttackCount(6L * 2);
        this.setDamage(330.0);
        this.setCooldown(7.0);
        this.setRelatedSkill(new LightningGodSpearStrikeDot());
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
