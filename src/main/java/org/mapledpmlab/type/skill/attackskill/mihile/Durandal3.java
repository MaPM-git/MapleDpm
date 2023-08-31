package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Durandal3 extends AttackSkill {
    public Durandal3() {
        this.setName("듀란달(마무리 일격)");
        this.setAttackCount(14L);
        this.setCooldown(360.0);
        this.setDamage(6600.0);
        this.setDotDuration(550L);
        this.setLimitAttackCount(5L);
        this.setInterval(110L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new DurandalDelay());
    }
}
