package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNeedle extends AttackSkill {
    public PoisonNeedle() {
        this.setName("[처형] 포이즌 니들");
        this.setDamage(710.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(360L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new PoisonNeedleLoop());
        this.setAddDamage(20L);
    }
}
