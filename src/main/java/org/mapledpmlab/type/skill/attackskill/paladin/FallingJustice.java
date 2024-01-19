package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FallingJustice extends AttackSkill {
    public FallingJustice() {
        this.setName("폴링 저스티스");
        this.setCooldown(30.0);
        this.setAttackCount(6L);
        this.setDamage(1300.0);
        this.setDotDuration(2520L);
        this.setInterval(120L);
        this.setLimitAttackCount(15L);
    }
}
