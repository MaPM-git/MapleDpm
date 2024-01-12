package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeImpForward extends AttackSkill {
    public BladeImpForward() {
        this.setName("파쇄철조-전");
        this.setDamage(110.0);
        this.setAttackCount(1L);
        this.setDotDuration(720L);
        this.setInterval(720L / 4);
        this.setLimitAttackCount(4L);
    }
}
