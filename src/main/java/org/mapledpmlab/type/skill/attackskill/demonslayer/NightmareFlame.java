package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class NightmareFlame extends GaugeAttackSkill {
    public NightmareFlame() {
        this.setName("나이트메어(명계의 화염)");
        this.setAttackCount(7L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(2229.0);
        this.addIgnoreDefenseList(50L);
        this.setAddDamage(50L);
        this.setCooldown(0.3);
        this.setGaugeCharge(10.0);
    }
}
