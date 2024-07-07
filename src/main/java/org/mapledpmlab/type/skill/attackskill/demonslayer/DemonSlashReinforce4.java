package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonSlashReinforce4 extends GaugeAttackSkill {
    public DemonSlashReinforce4() {
        this.setName("강화 데몬 슬래시(4타)");
        this.setAttackCount(3L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(800.0 + 80 + 80);
        this.setDelayByAttackSpeed(450L);
        this.setAddDamage(30L + 30 + 50);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.3);
        this.addFinalDamage(1.1);           // 데몬 슬래시-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(5 + 2 * 0.75);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
