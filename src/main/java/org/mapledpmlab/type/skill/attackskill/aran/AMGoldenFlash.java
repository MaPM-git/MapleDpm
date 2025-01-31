package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AMGoldenFlash extends AttackSkill {
    public AMGoldenFlash() {
        this.setName("아드레날린 맥시멈(금빛 섬광)");
        this.setDamage(1190.0);
        this.setAttackCount(10L);
        this.setCooldown(0.8);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
