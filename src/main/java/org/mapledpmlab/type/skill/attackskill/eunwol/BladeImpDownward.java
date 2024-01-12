package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImpDownward extends AttackSkill {
    public BladeImpDownward() {
        this.setName("파쇄철조-하");
        this.setDamage(100.0);
        this.setAttackCount(1L);
        this.setDotDuration(630L);
        this.setInterval(630L / 4);
        this.setLimitAttackCount(4L);
    }
}
