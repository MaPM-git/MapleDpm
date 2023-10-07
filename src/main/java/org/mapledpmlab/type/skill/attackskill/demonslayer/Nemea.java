package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Nemea extends GaugeAttackSkill {
    public Nemea() {
        this.setName("네메아");
        this.setAttackCount(12L);
        this.setDamage(880.0);
        this.setDotDuration(55000L);
        this.setInterval(2000L);
        this.setRelatedSkill(new Geryon());
        this.setGaugeCharge(8.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
