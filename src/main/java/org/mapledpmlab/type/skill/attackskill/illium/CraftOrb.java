package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CraftOrb extends AttackSkill {
    public CraftOrb() {
        this.setName("크래프트:오브");
        this.setDamage(50.0 + 264);
        this.setDelayByAttackSpeed(480L);
        this.setAttackCount(1L);
    }
}
