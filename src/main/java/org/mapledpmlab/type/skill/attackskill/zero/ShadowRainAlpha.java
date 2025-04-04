package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowRainAlpha extends AttackSkill {
    public ShadowRainAlpha() {
        this.setName("쉐도우 레인(알파)");
        this.setAttackCount(14L);
        this.setDamage(1625.0);
        this.setDelayByAttackSpeed(4410L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(3690L);
    }
}
