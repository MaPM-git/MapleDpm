package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ClaimhSolais extends AttackSkill {
    public ClaimhSolais() {
        this.setName("클라우 솔라스");
        this.setApplyFinalAttack(true);
        this.setAttackCount(15L);
        this.setDamage(2200.0);
        this.setCooldown(12.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
