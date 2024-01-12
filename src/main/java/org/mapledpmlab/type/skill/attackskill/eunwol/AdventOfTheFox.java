package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdventOfTheFox extends AttackSkill {
    public AdventOfTheFox() {
        this.setName("호신강림");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(1920.0);
        this.setDotDuration(4020L);
        this.setLimitAttackCount(8L);
        this.setInterval(4020L / 8);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new AdventOfTheFoxDelay());
    }
}
