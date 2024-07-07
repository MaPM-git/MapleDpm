package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BrandishMaha extends AttackSkill {
    public BrandishMaha() {
        this.setName("브랜디쉬 마하");
        this.setDamage(1320.0 + 5 + 21 + 100);
        this.setAttackCount(15L);
        this.setDelay(960L);
        this.setDotDuration(960L);
        this.setInterval(480L);
        this.setLimitAttackCount(2L);
        this.setAddDamage(20L);
        this.setCooldown(20.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}

