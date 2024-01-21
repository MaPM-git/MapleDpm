package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion3 extends AttackSkill {
    public PoisonChainExplosion3() {
        this.setName("포이즌 체인(독 폭발, 3중첩)");
        this.setDamage(330.0 + 60 * 3);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChainExplosion4());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1800L * 3);
    }
}