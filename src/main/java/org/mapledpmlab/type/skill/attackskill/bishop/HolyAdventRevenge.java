package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HolyAdventRevenge extends AttackSkill {
    public HolyAdventRevenge() {
        this.setName("홀리 어드밴트(복수의 천사)");
        this.setAttackCount(12L);
        this.setDamage(600.0);
        this.setDotDuration(60000L);
        this.setInterval(5000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HolyAdventCharity());
    }
}
