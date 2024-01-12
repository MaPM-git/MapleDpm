package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShockwavePunch2 extends AttackSkill {
    public ShockwavePunch2() {
        this.setName("통백권(2타)");
        this.setDamage(330.0);
        this.setAttackCount(1L);
        this.setDotDuration(660L);
        this.setInterval(660L / 3);
        this.setLimitAttackCount(3L);
        this.setRelatedSkill(new ShockwavePunch3());
    }
}
