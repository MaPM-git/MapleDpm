package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AnemoiDot extends AttackSkill {
    public AnemoiDot() {
        this.setName("아네모이(강력한 바람)");
        this.setAttackCount(10L);
        this.setDamage(1879.0);
        this.setCooldown(60.0);
        this.setDotDuration(20000L);
        this.setInterval(1200L);
        this.setLimitAttackCount(16L);
        this.setRelatedSkill(new Anemoi());
    }
}
