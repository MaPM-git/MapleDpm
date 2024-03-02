package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FallingDustEnchantMalice extends AttackSkill {
    public FallingDustEnchantMalice() {
        this.setName("[발현] 폴링 더스트(악의)");
        this.setDamage(755.0);
        this.setAttackCount(15L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
    }
}
