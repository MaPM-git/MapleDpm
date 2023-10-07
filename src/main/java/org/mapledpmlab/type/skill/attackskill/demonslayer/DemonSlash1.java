package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonSlash1 extends GaugeAttackSkill {
    public DemonSlash1() {
        this.setName("데몬 슬래시(1타)");
        this.setAttackCount(2L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(110.0 + 80);
        this.setDelayByAttackSpeed(330L);
        this.setAddDamage(30L + 30);
        this.addFinalDamage(1.3);
        this.addFinalDamage(1.1);           // 데몬 슬래시-리인포스
        this.setRelatedSkill(new DemonSlash2());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(5 + 2 * 0.75);
    }
}
