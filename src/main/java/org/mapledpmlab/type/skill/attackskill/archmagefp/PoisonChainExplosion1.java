package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion1 extends AttackSkill {
    public PoisonChainExplosion1() {
        this.setName("포이즌 체인(독 폭발, 1중첩)");
        this.setDamage(330.0 + 60);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChainExplosion2());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1800L);
    }
}