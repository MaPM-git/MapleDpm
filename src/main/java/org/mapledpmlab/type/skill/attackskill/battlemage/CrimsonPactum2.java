package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrimsonPactum2 extends AttackSkill {
    public CrimsonPactum2() {
        this.setName("크림슨 팩텀2");
        this.setAttackCount(14L);
        this.setDamage(12600.0);
        this.setLimitAttackCount(5L);
        this.setDotDuration(2550L);
        this.setInterval(510L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new CrimsonPactum2Delay());
        this.setApplyFinalAttack(true);
    }
}
