package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HolyAdvent1 extends AttackSkill {
    public HolyAdvent1() {
        this.setName("홀리 어드밴트(참격1)");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(3120.0);
        this.setDotDuration(3000L);
        this.setLimitAttackCount(6L);
        this.setInterval(500L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HolyAdvent2());
    }
}
