package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Silence extends AttackSkill {
    public Silence() {
        this.setName("사일런스");
        this.setAttackCount(8L);
        this.setDamage(6000.0);
        this.setDotDuration(5100L);
        this.setLimitAttackCount(8L);
        this.setInterval(637L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SilenceDelay());
    }
}
