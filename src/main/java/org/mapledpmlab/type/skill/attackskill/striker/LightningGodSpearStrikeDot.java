package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightningGodSpearStrikeDot extends AttackSkill {
    public LightningGodSpearStrikeDot() {
        this.setName("뇌신창격(전격)");
        this.setAttackCount(7L * 2);
        this.setDamage(440.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
        this.getMultiAttackInfo().add(1000L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
