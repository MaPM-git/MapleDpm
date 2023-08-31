package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Durandal1 extends AttackSkill {
    public Durandal1() {
        this.setName("듀란달(참격)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(4500.0);
        this.setDotDuration(2000L);
        this.setLimitAttackCount(2L);
        this.setInterval(1000L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new Durandal2());
    }
}
