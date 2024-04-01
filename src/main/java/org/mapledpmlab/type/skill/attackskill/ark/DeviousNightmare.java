package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeviousNightmare extends AttackSkill implements LefSkill {
    public DeviousNightmare() {
        this.setName("새어 나오는 악몽");
        this.setDamage(1100.0);
        this.setAttackCount(12L);
        this.setCooldown(10.0);
        this.addFinalDamage(1.6);
    }
}
