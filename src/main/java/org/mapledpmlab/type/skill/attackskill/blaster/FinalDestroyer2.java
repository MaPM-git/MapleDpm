package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalDestroyer2 extends AttackSkill {
    public FinalDestroyer2() {
        this.setName("파이널 디스트로이어(폭발)");
        this.setAttackCount(14L);
        this.setDamage(6600.0);
        this.setDotDuration(1260L);
        this.setLimitAttackCount(7L);
        this.setInterval(180L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FinalDestroyerDelay2());
        this.setApplyFinalAttack(true);
    }
}
