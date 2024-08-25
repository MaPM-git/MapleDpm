package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.DominionBuff;

public class DominionSummonBat extends AttackSkill implements DarkAttack {
    public DominionSummonBat() {
        this.setName("도미니언(배트 소환)");
        this.setCooldown(0.7);
        this.setApplyCooldownReduction(false);
    }
}
