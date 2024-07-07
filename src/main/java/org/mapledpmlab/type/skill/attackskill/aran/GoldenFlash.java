package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GoldenFlash extends AttackSkill {
    public GoldenFlash() {
        this.setName("금빛 섬광");
        this.setDamage(660.0);
        this.setAttackCount(10L);
        this.setCooldown(1.2);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
