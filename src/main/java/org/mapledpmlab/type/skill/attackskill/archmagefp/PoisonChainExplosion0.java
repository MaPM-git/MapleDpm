package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion0 extends AttackSkill {
    public PoisonChainExplosion0() {
        this.setName("포이즌 체인(독 폭발, 0중첩)");
        this.setDamage(330.0);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChainExplosion1());
        this.setApplyFinalAttack(true);
    }
}