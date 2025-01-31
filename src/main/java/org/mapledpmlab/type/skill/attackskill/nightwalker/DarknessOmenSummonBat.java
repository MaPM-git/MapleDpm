package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarknessOmenSummonBat extends AttackSkill implements DarkAttack {
    public DarknessOmenSummonBat() {
        this.setName("다크니스 오멘(배트 소환)");
        this.setCooldown(0.9);
        this.setApplyCooldownReduction(false);
    }
}
