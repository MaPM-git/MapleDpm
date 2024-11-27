package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistMethodMountainSpiritSummonRoar extends AttackSkill {
    public FistMethodMountainSpiritSummonRoar() {
        this.setName("권술 : 산령소환(포효)");
        this.setDamage(770.0);
        this.setAttackCount(4L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
