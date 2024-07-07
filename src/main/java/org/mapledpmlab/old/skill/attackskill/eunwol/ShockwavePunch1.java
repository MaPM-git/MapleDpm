package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShockwavePunch1 extends AttackSkill {
    public ShockwavePunch1() {
        this.setName("통백권(1타)");
        this.setDamage(310.0);
        this.setAttackCount(3L);
        this.setRelatedSkill(new ShockwavePunch2());
        this.getMultiAttackInfo().add(360L);
    }
}
