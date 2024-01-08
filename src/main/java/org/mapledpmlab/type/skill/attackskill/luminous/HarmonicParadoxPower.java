package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HarmonicParadoxPower extends AttackSkill {
    public HarmonicParadoxPower() {
        this.setName("하모닉 패러독스(진리의 권능)");
        this.setAttackCount(7L * 2);
        this.setDamage(6000.0);
        this.setDotDuration(5280L);
        this.setLimitAttackCount(10L);
        this.setInterval(528L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HarmonicParadoxPowerDelay());
    }
}
