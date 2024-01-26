package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HolyAdventBalance extends AttackSkill {
    public HolyAdventBalance() {
        this.setName("홀리 어드밴트(균형의 천사)");
        this.setAttackCount(14L);
        this.setDamage(515.0);
        this.setDotDuration(60000L);
        this.setInterval(3000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HolyAdventRevenge());
    }
}
