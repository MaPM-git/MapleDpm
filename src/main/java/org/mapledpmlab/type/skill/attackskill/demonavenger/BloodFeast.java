package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class BloodFeast extends GaugeAttackSkill {
    public BloodFeast() {
        this.setName("블러드 피스트");
        this.setAttackCount(12L);
        this.setDamage(1595.0);
        this.setDelayByAttackSpeed(420L);
        this.addIgnoreDefenseList(100L);
        this.setGaugePer(22L);
        this.setCooldown(12.0);
        this.addFinalDamage(1.6);   // 코어 강화
    }
}
