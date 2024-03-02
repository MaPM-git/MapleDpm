package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShaftBreakEnchantTornado extends AttackSkill {
    public ShaftBreakEnchantTornado() {
        this.setName("[발현] 샤프트 브레이크(회오리)");
        this.setDamage(55.0 + 31);
        this.setAttackCount(3L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(1440L);
        this.setInterval(120L);
        this.setLimitAttackCount(12L);
        this.setAddDamage(10L + 15);
    }
}
