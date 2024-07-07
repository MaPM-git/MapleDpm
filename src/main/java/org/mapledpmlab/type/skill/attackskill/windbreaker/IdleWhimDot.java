package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class IdleWhimDot extends DotAttackSkill {
    public IdleWhimDot() {
        this.setName("아이들 윔(도트)");
        this.setAttackCount(1L);
        this.setDamage(1100.0);
        this.setDotDuration(9000L);
        this.setInterval(1000L);
        this.setLimitAttackCount(9L);
    }
}
