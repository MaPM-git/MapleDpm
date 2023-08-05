package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChain extends AttackSkill {
    public PoisonChain() {
        this.setName("포이즌 체인");
        this.setDamage(500.0);
        this.setCooldown(25.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
    }
}