package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagneticFieldSummon extends AttackSkill {
    public MagneticFieldSummon() {
        this.setName("마그네틱 필드");
        this.setDelay(630L);
        this.setRelatedSkill(new MagneticField());
    }
}
