package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Durandal2 extends AttackSkill {
    public Durandal2() {
        this.setName("듀란달(대지의 파동)");
        this.setAttackCount(5L);
        this.setCooldown(360.0);
        this.setDamage(5400.0);
        this.setDotDuration(2700L);
        this.setLimitAttackCount(9L);
        this.setInterval(300L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new Durandal3());
    }
}
