package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class BleedingToxinDot extends DotAttackSkill {
    public BleedingToxinDot() {
        this.setName("블리딩 톡신(도트)");
        this.setAttackCount(1L);
        this.setDamage(2000.0);
        this.setDotDuration(90000L);
        this.setInterval(1000L);
    }
}
