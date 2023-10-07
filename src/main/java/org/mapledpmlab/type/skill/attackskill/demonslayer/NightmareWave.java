package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class NightmareWave extends GaugeAttackSkill {
    public NightmareWave() {
        this.setName("나이트메어(파동)");
        this.setDotDuration(3000L);
        this.setInterval(600L);
        this.setLimitAttackCount(5L);
        this.setAttackCount(4L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(3600.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setCooldown(360.0);
        this.setRelatedSkill(new NightmareWaveDelay());
        this.setGaugeCharge(-50.0);
    }
}
