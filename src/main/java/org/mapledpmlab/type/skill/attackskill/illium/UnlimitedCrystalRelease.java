package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnlimitedCrystalRelease extends AttackSkill {
    public UnlimitedCrystalRelease() {
        this.setName("언리미티드 크리스탈(크리스탈 결정)");
        this.setAttackCount(2L);
        this.setDamage(1200.0);
        this.setCooldown(2.0);
        this.setDotDuration(1050L);
        this.setInterval(30L);
        this.setLimitAttackCount(25L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
