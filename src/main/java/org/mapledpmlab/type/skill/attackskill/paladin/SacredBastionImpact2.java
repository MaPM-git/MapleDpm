package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SacredBastionImpact2 extends AttackSkill {
    public SacredBastionImpact2() {
        this.setName("세이크리드 바스티온(충격파2)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(12L);
        this.setDamage(3300.0);
        this.setDotDuration(1200L);
        this.setLimitAttackCount(12L);
        this.setInterval(100L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SacredBastionDelay());
    }
}
