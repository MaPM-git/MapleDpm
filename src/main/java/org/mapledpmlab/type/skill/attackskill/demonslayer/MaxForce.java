package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class MaxForce extends GaugeAttackSkill {
    public MaxForce() {
        this.setName("맥스 포스");
        this.setDotDuration(720000L);
        this.setInterval(4000L);
        this.setGaugeCharge(10.0);
    }
}
