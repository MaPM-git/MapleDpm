package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BrandishMaha extends AttackSkill {
    public BrandishMaha() {
        this.setName("브랜디쉬 마하");
        this.setDamage(1210.0);
        this.setAttackCount(12L);
        this.setDelayByAttackSpeed(960L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
        this.setAddDamage(20L);
        this.setCooldown(20.0);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(150L);
    }
}
