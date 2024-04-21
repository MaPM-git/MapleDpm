package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShockwavePunch2 extends AttackSkill {
    public ShockwavePunch2() {
        this.setName("통백권(2타)");
        this.setDamage(330.0);
        this.setAttackCount(3L);
        this.setRelatedSkill(new ShockwavePunch3());
        this.getMultiAttackInfo().add(660L);
    }
}
