package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ThornOfFury extends GaugeAttackSkill {
    public ThornOfFury() {
        this.setName("분노의 가시");
        this.setAttackCount(12L);
        this.setDamage(990.0);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(4.0);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
