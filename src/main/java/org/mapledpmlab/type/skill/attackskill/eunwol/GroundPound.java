package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundPound extends AttackSkill {
    public GroundPound() {
        this.setName("파력권");
        this.setDamage(360.0);
        this.setAttackCount(1L);
        this.setDotDuration(720L);
        this.setInterval(720L / 4);
        this.setLimitAttackCount(4L);
    }
}
