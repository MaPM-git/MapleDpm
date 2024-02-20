package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Jormungand extends GaugeAttackSkill {
    public Jormungand() {
        this.setName("요르문간드");  // 첫 공격까지 1980ms
        this.setDelay(810L);
        this.setDotDuration(16000L);
        this.setInterval(1080L);
        this.setLimitAttackCount(13L);
        this.setAttackCount(12L);
        this.setDamage(2120.0);
        this.addIgnoreDefenseList(50L);
        this.setGaugeCharge(-60.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setCooldown(120.0);
    }
}
