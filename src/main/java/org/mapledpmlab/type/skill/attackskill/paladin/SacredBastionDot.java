package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SacredBastionDot extends AttackSkill {
    public SacredBastionDot() {
        this.setName("세이크리드 바스티온(심판의 빛)");
        this.setDamage(1800.0);
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDotDuration(30000L);
        this.setInterval(500L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
