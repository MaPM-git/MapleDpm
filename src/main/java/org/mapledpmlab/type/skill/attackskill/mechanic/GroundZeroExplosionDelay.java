package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroExplosionDelay extends AttackSkill {
    public GroundZeroExplosionDelay() {
        this.setName("그라운드 제로(폭발)");
        this.setDelay(960L);
        this.setRelatedSkill(new GroundZeroBombardment());
    }
}
