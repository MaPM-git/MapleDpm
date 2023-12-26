package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroEarthquakeDelay extends AttackSkill {
    public GroundZeroEarthquakeDelay() {
        this.setName("그라운드 제로(지진)");
        this.setDelay(3900L);
        this.setRelatedSkill(new GroundZeroExplosion());
    }
}
