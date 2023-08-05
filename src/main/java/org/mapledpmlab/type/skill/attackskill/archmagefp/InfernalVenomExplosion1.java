package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernalVenomExplosion1 extends AttackSkill {
    public InfernalVenomExplosion1() {
        this.setName("인페르날 베놈(폭발1)");
        this.setAttackCount(8L);
        this.setDamage(7200.0);
        this.setDotDuration(3000L);
        this.setInterval(600L);
        this.setLimitAttackCount(6L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new InfernalVenomExplosion2());
    }
}
