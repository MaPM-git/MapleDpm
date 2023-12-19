package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNova extends AttackSkill {
    public PoisonNova() {
        this.setName("포이즌 노바");
        this.setDamage(550.0);
        this.setAttackCount(12L);
        this.setCooldown(25.0);
        this.setDelay(750L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
    }
}
