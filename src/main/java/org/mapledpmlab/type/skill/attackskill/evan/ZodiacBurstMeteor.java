package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacBurstMeteor extends AttackSkill {
    public ZodiacBurstMeteor() {
        this.setName("조디악 버스트(유성우)");
        this.setDamage(1440.0);
        this.setAttackCount(54L);
        this.setDotDuration(45000L);
        this.setInterval(9000L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
