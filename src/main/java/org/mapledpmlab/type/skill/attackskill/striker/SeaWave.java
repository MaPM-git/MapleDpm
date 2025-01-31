package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SeaWave extends AttackSkill {
    public SeaWave() {
        this.setName("해파");
        this.setAttackCount(5L * 2);
        this.setDamage(1010.0);
        this.setCooldown(12.0);
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(4.0);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
