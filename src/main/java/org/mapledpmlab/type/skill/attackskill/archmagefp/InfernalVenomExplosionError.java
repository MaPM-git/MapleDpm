package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernalVenomExplosionError extends AttackSkill {
    public InfernalVenomExplosionError() {
        this.setName("인페르날 베놈(오류)");
        this.setAttackCount(12L);
        this.setDamage(540.0);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new InfernalVenomExplosion2());
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
