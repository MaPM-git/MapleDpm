package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class VenomBurst extends DotAttackSkill {
    public VenomBurst() {
        this.setName("베놈 버스트");
        this.setAttackCount(1L);
        this.setDamage(340.0);
        this.setInterval(1000L);
        this.setDotDuration(720000L);
    }
}
