package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WaterWave extends AttackSkill {
    public WaterWave() {
        this.setName("파도");
        this.setAttackCount(2L);
        this.setDamage(255.0);
        this.setDelayByAttackSpeed(210L);
        this.addFinalDamage(4.0);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.18);          // 연쇄
    }
}
