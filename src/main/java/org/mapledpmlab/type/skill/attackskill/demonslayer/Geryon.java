package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Geryon extends GaugeAttackSkill {
    public Geryon() {
        this.setName("게리온");
        this.setAttackCount(10L);
        this.setDamage(1980.0);
        this.setDotDuration(55000L);
        this.setInterval(3000L);
        this.setGaugeCharge(12.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
