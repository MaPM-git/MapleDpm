package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonSlash extends AttackSkill {
    public DragonSlash() {
        this.setName("드래곤슬래시(1타)");
        this.setDamage(70.0);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(270L);
        this.setAddDamage(40L + 70 + 90);
        this.setCooldown(20.0);
        this.setApplyCooldownReduction(false);
    }
}
