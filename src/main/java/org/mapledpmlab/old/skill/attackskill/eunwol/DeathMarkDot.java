package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class DeathMarkDot extends DotAttackSkill {
    public DeathMarkDot() {
        this.setName("사혼 각인(죽음의 표식)");
        this.setDamage(255.0);
        this.setAttackCount(1L);
        this.setDotDuration(15000L);
        this.setInterval(1000L);
    }
}
