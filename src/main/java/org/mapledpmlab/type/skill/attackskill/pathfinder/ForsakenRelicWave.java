package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ForsakenRelicWave extends GaugeAttackSkill {
    public ForsakenRelicWave() {
        this.setName("포세이큰 렐릭(파동)");
        this.setAttackCount(8L);
        this.setDamage(8400.0);
        this.setCooldown(360.0);
        this.setDotDuration(4500L);
        this.setInterval(900L);
        this.setLimitAttackCount(5L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new ForsakenRelicWaveDelay());
    }
}
