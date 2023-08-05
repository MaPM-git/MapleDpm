package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChainExplosion extends AttackSkill {
    public PoisonChainExplosion() {
        this.setName("포이즌 체인(독 폭발)");
        this.setDamage(563.3);          // 9번 데미지 평균
        this.setCooldown(25.0);
        this.setAttackCount(5L);
        this.setDotDuration(20000L);
        this.setInterval(1800L);
        this.setLimitAttackCount(9L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PoisonChain());
        this.setApplyFinalAttack(true);
    }
}