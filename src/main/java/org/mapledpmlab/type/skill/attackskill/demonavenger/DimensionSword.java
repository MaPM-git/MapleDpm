package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DimensionSword extends GaugeAttackSkill {
    public DimensionSword() {
        this.setName("디멘션 소드");
        this.setAttackCount(10L);
        this.setDamage(1100.0);
        this.setDotDuration(8000L);
        this.setInterval(170L);
        this.setLimitAttackCount(42L);
        this.addIgnoreDefenseList(100L);
        this.setCooldown(120.0);
        this.addFinalDamage(1.6);   // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
