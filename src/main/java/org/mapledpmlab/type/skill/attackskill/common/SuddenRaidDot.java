package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class SuddenRaidDot extends DotAttackSkill {
    public SuddenRaidDot() {
        this.setName("써든레이드(도트)");
        this.setAttackCount(1L);
        this.setDamage(210.0);
        this.setDotDuration(10000L);
        this.setInterval(1000L);
    }
}
