package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroExplosion extends AttackSkill {
    public GroundZeroExplosion() {
        this.setName("그라운드 제로(폭발)");
        this.setAttackCount(12L);
        this.setDamage(13200.0);
        this.setDotDuration(960L);
        this.setInterval(160L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new GroundZeroExplosionDelay());
    }
}
