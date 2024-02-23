package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GroundZeroEarthquake extends AttackSkill {
    public GroundZeroEarthquake() {
        this.setName("그라운드 제로(지진)");
        this.setAttackCount(8L);
        this.setDelay(3060L);
        this.setCooldown(360.0);
        this.setDamage(2040.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new GroundZeroExplosion());
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(1260L);
        this.getMultiAttackInfo().add(780L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
