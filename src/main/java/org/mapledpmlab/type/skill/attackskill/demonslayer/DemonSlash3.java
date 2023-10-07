package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonSlash3 extends GaugeAttackSkill {
    public DemonSlash3() {
        this.setName("데몬 슬래시(3타)");
        this.setAttackCount(3L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(100.0 + 80);
        this.setDelayByAttackSpeed(450L);
        this.setAddDamage(30L);
        this.setAddDamage(30L + 30);
        this.addFinalDamage(1.3);
        this.addFinalDamage(1.1);           // 데몬 슬래시-리인포스
        this.setRelatedSkill(new DemonSlash4());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(5 + 2 * 0.75);
    }
}
