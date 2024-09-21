package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulOfCrystal extends AttackSkill {
    public SoulOfCrystal() {
        this.setName("소울 오브 크리스탈");
        this.setDelay(660L);
        this.setCooldown(40.0);
        this.setApplyCooldownReduction(false);
        this.setApplyServerLag(true);
    }
}
