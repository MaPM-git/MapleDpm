package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ShadowRainBeta extends GaugeAttackSkill {
    public ShadowRainBeta() {
        this.setName("쉐도우 레인(베타)");
        this.setAttackCount(14L);
        this.setDamage(1625.0);
        this.setCooldown(300.0);
        this.setRelatedSkill(new ShadowRainAlpha());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.setGaugeCharge(-50.0);
    }
}
