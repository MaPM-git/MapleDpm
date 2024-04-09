package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightSphereDot extends AttackSkill {
    public LightSphereDot() {
        this.setName("빛의 창(도트)");
        this.setAttackCount(4L);
        this.setDamage(440.0);
        this.setDotDuration(2000L);
        this.setInterval(120L);
        this.setLimitAttackCount(5L);
    }
}
