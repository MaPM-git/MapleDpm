package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonicSphere extends GaugeAttackSkill {
    public DemonicSphere() {
        this.setName("데모닉 스피어");
        this.setAttackCount(6L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(500.0 + 80);
        this.setCooldown(6.0);
        this.setAddDamage(30L + 30 + 50);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.3);
        this.addFinalDamage(1.1);           // 데몬 슬래시-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(5 + 2 * 0.75);
        this.getMultiAttackInfo().add(100L);
    }
}
