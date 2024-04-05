package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistMethodMountainSpiritSummonRoar extends AttackSkill {
    public FistMethodMountainSpiritSummonRoar() {
        this.setName("권술 : 산령소환(포효)");
        this.setDamage(770.0);
        this.setCooldown(3.0);
        this.setAttackCount(4L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
