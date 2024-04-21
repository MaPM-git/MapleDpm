package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundPound extends AttackSkill {
    public GroundPound() {
        this.setName("파력권");
        this.setDamage(360.0);
        this.setAttackCount(4L);
        this.getMultiAttackInfo().add(720L);
    }
}
