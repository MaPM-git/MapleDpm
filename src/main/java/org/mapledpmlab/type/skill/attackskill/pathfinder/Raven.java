package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Raven extends GaugeAttackSkill {
    public Raven() {
        this.setName("레이븐");
        //this.setDelay(600L);
        //this.setCooldown(225.0);
        this.setAttackCount(1L);
        this.setDamage(585.0);
        this.setDotDuration(720000L);
        this.setInterval(3030L);
        this.setFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(30.0);
    }
}
