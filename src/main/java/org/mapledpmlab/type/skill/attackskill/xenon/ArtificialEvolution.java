package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtificialEvolution extends AttackSkill {
    public ArtificialEvolution() {
        this.setName("아티피셜 에볼루션");
        this.setAttackCount(7L * 2);
        this.setDamage(3600.0);
        this.setCooldown(360.0);
        this.setLimitAttackCount(6L);
        this.setDotDuration(5400L);
        this.setInterval(900L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new ArtificialEvolutionDelay());
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
