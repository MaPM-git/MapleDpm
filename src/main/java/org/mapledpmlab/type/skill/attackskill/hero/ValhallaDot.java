package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ValhallaDot extends AttackSkill {
    public ValhallaDot() {
        this.setName("발할라(검격)");
        this.setAttackCount(15L);
        this.setDamage(404.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(0.57);
        this.setApplyCooldownReduction(false);
    }
}
