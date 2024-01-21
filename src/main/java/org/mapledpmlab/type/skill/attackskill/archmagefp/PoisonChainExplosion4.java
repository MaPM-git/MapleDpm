package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion4 extends AttackSkill {
    public PoisonChainExplosion4() {
        this.setName("포이즌 체인(독 폭발, 4중첩)");
        this.setDamage(330.0 + 60 * 4);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChainExplosion5());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1800L * 4);
    }
}