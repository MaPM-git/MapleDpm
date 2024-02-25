package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HarmonicParadoxKeydown extends AttackSkill {
    public HarmonicParadoxKeydown() {
        this.setName("하모닉 패러독스(키다운)");
        this.setAttackCount(7L * 2);
        this.setCooldown(360.0);
        this.setDamage(3000.0);
        this.setDelay(3060L);
        this.setDotDuration(3060L);
        this.setLimitAttackCount(17L);
        this.setInterval(180L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new HarmonicParadoxPower());
    }
}
