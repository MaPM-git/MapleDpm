package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SacredBastionImpact1 extends AttackSkill {
    public SacredBastionImpact1() {
        this.setName("세이크리드 바스티온(충격파1)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L);
        this.setDamage(3600.0);
        this.setDotDuration(4200L);
        this.setLimitAttackCount(7L);
        this.setInterval(600L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
