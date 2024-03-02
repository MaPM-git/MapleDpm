package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShaftBreakEnchantBomb extends AttackSkill {
    public ShaftBreakEnchantBomb() {
        this.setName("[발현] 샤프트 브레이크(폭발)");
        this.setDamage(270.0 + 206);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(390L);
        this.setRelatedSkill(new ShaftBreakEnchantTornado());
        this.setAddDamage(10L + 15);
    }
}
