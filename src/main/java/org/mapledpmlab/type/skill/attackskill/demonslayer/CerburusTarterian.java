package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class CerburusTarterian extends GaugeAttackSkill {
    public CerburusTarterian() {
        this.setName("서버러스 : 타테리안 서버러스");
        this.setAttackCount(7L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(410.0);
        this.addIgnoreDefenseList(50L);
        this.setAddDamage(50L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(50.0);
        this.setDelayByAttackSpeed(780L);
        this.getMultiAttackInfo().add(330L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
