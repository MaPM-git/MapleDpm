package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthBreakShockWave extends AttackSkill implements BetaSkill {
    public EarthBreakShockWave() {
        this.setName("어스 브레이크(충격파)");
        this.setAttackCount(10L);
        this.setDamage(455.0);
        this.setDelayByAttackSpeed(513L);
        this.setRelatedSkill(new EarthBreakElectricity());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
