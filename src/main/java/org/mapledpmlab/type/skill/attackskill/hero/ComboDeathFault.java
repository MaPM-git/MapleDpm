package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ComboDeathFault extends AttackSkill {
    public ComboDeathFault() {
        this.setName("콤보 데스폴트");
        this.setAttackCount(14L);
        this.setCooldown(25.0);
        this.setDamage(880.0);
        this.setDelay(1680L);
        this.setFinalDamage(1.6);
        this.setApplyFinalAttack(true);
    }
}
