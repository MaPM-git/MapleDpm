package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GlacialFrozen extends AttackSkill {
    public GlacialFrozen() {
        this.setName("글레이셜 프리즌");
        this.setDamage(486.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(990L);
        this.setApplyFinalAttack(true);
        this.setCooldown(180.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
