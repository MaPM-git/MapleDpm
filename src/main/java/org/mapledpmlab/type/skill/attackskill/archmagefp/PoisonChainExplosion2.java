package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion2 extends AttackSkill {
    public PoisonChainExplosion2() {
        this.setName("포이즌 체인(독 폭발, 2중첩)");
        this.setDamage(330.0 + 60 * 2);
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChainExplosion3());
        this.getMultiAttackInfo().add(1800L * 2);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}