package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShaftBreakEnchant extends AttackSkill {
    public ShaftBreakEnchant() {
        this.setName("[발현] 샤프트 브레이크");
        this.setDamage(216.0 + 206);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(11.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new ShaftBreakEnchantBomb());
        this.setAddDamage(10L + 15);
        this.setApplyCooldownReduction(false);
    }
}
