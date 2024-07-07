package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulConcentrationAutoCool extends AttackSkill {
    public SoulConcentrationAutoCool() {
        this.setName("정령 집속(자동 쿨타임)");
        this.setCooldown(2.0);
        this.setApplyCooldownReduction(false);
    }
}
