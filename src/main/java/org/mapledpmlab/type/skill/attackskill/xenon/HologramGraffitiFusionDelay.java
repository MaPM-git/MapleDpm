package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HologramGraffitiFusionDelay extends AttackSkill {
    public HologramGraffitiFusionDelay() {
        this.setName("홀로그램 그래피티 : 융합");
        this.setDelay(930L);
        this.setRelatedSkill(new HologramGraffitiFusion());
        this.setCooldown(90.0);
    }
}
