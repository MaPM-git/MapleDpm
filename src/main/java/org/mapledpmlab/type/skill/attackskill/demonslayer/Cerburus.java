package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Cerburus extends GaugeAttackSkill {
    public Cerburus() {
        this.setName("서버러스(자동)");
        this.setAttackCount(6L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(450.0);
        //this.setDelayByAttackSpeed(780L);
        this.addIgnoreDefenseList(50L);
        this.setAddDamage(50L);
        this.setCooldown(8.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(50.0);
    }
}
