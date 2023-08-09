package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ForsakenRelicExplosion extends GaugeAttackSkill {
    public ForsakenRelicExplosion() {
        this.setName("포세이큰 렐릭(폭발)");
        this.setAttackCount(13L);
        this.setDamage(9900.0);
        this.setCooldown(360.0);
        this.setDotDuration(2040L);
        this.setInterval(408L);
        this.setLimitAttackCount(5L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new ForsakenRelicExplosionDelay());
    }
}
