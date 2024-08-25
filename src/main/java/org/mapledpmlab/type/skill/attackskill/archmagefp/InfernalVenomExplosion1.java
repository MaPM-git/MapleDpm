package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernalVenomExplosion1 extends AttackSkill {
    public InfernalVenomExplosion1() {
        this.setName("인페르날 베놈(폭발1)");
        this.setAttackCount(12L);
        this.setDamage(540.0);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new InfernalVenomExplosionError());
        this.getMultiAttackInfo().add(2820L);
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
