package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShockwavePunch1 extends AttackSkill {
    public ShockwavePunch1() {
        this.setName("통백권(1타)");
        this.setDamage(310.0);
        this.setAttackCount(1L);
        this.setDotDuration(360L);
        this.setInterval(360L / 3);
        this.setLimitAttackCount(3L);
        this.setRelatedSkill(new ShockwavePunch2());
    }
}
