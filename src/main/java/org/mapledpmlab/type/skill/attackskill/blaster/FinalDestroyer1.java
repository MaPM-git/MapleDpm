package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalDestroyer1 extends AttackSkill {
    public FinalDestroyer1() {
        this.setName("파이널 디스트로이어(열기)");
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setDamage(5400.0);
        this.setDotDuration(6000L);
        this.setLimitAttackCount(12L);
        this.setInterval(500L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FinalDestroyerDelay1());
        this.setApplyFinalAttack(true);
    }
}
