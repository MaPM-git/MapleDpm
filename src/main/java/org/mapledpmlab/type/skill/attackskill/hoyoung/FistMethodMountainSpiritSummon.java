package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistMethodMountainSpiritSummon extends AttackSkill {
    public FistMethodMountainSpiritSummon() {
        this.setName("권술 : 산령소환");
        this.setDamage(1980.0);
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(120.0);
        this.setAttackCount(8L);
        this.setDotDuration(40000L);
        this.setApplyServerLag(true);
        this.setInterval(3000L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
