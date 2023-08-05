package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.archmagefp.InfernalVenomBuff;

public class InfernalVenomExplosion2 extends AttackSkill {
    public InfernalVenomExplosion2() {
        this.setName("인페르날 베놈(폭발2)");
        this.setAttackCount(12L);
        this.setDamage(5400.0);
        this.setDotDuration(3600L);
        this.setLimitAttackCount(8L);
        this.setInterval(450L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new InfernalVenomBuff());
    }
}
