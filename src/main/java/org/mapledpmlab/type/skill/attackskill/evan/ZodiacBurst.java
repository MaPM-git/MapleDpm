package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacBurst extends AttackSkill {
    public ZodiacBurst() {
        this.setName("조디악 버스트");
        this.setDamage(5400.0);
        this.setAttackCount(15L);
        this.setDotDuration(3180L);
        this.setInterval(636L);
        this.setLimitAttackCount(5L);
        this.setRelatedSkill(new ZodiacBurstDelay());
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
