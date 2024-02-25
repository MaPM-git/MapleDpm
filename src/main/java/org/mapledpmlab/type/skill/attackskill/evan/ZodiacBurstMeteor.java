package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacBurstMeteor extends AttackSkill {
    public ZodiacBurstMeteor() {
        this.setName("조디악 버스트(유성우)");
        this.setDamage(1080.0);
        this.setAttackCount(72L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(3.0);
        this.getMultiAttackInfo().add(240L);
    }
}
