package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroEarthquake extends AttackSkill {
    public GroundZeroEarthquake() {
        this.setName("그라운드 제로(지진)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(7800.0);
        this.setDotDuration(3900L);
        this.setInterval(1300L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new GroundZeroEarthquakeDelay());
    }
}
