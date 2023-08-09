package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Raven extends GaugeAttackSkill {
    public Raven() {
        this.setName("레이븐");
        this.setAttackCount(1L);
        this.setDamage(390.0);
        this.setDotDuration(220000L);
        this.setInterval(1710L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(10L);
    }
}
