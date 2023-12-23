package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NaturesBeliefWave extends AttackSkill {
    public NaturesBeliefWave() {
        this.setName("네이쳐스 빌리프(파동)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(7800.0);
        this.setLimitAttackCount(3L);
        this.setDotDuration(3180L);
        this.setInterval(1060L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new NaturesBeliefWaveDelay());
    }
}
