package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MysticEnergyIllusionOfHeavenEarthAndHumanAttack extends AttackSkill {
    public MysticEnergyIllusionOfHeavenEarthAndHumanAttack() {
        this.setName("선기 : 천지인 환영");
        this.setDamage(1375.0);
        this.setAttackCount(6L);
        this.setCooldown(5.0);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
