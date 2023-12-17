package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Requiem extends GaugeAttackSkill {
    public Requiem() {
        this.setName("레퀴엠");
        this.setDotDuration(3600L);
        this.setInterval(360L);
        this.setLimitAttackCount(10L);
        this.setAttackCount(8L);
        this.setDamage(7500.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setCooldown(360.0);
        this.setGaugePer(-15L);
        this.setRelatedSkill(new RequiemDelay());
        this.setApplyFinalAttack(true);
    }
}
