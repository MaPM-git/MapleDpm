package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnlimitedCrystalResonance extends AttackSkill {
    public UnlimitedCrystalResonance() {
        this.setName("언리미티드 크리스탈(공명)");
        this.setAttackCount(15L);
        this.setDamage(1920.0);
        this.setCooldown(1.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
