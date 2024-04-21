package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FallingDustEnchant extends AttackSkill {
    public FallingDustEnchant() {
        this.setName("[발현] 폴링 더스트");
        this.setDamage(1030.0);
        this.setAttackCount(10L);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(14.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new FallingDustEnchantMalice());
        this.setAddDamage(10L + 15);
        this.setApplyReuse(true);
    }
}
