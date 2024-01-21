package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion5 extends AttackSkill {
    public PoisonChainExplosion5() {
        this.setName("포이즌 체인(독 폭발, 5중첩)");
        this.setDamage(330.0 + 60 * 5);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChain());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1800L * 5);
        this.getMultiAttackInfo().add(1800L);
        this.getMultiAttackInfo().add(1800L);
        this.getMultiAttackInfo().add(1800L);
    }
}