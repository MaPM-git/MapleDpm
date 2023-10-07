package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class NightmareFlame extends GaugeAttackSkill {
    public NightmareFlame() {
        this.setName("나이트메어(명계의 화염)");
        this.setAttackCount(4L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(3900.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setCooldown(0.3);
        this.setGaugeCharge(10.0);
    }
}
