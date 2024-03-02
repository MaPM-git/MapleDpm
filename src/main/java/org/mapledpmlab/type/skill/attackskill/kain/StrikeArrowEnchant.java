package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrikeArrowEnchant extends AttackSkill {
    public StrikeArrowEnchant() {
        this.setName("[발현] 스트라이크 애로우");
        this.setDamage(1020.0 + 120 + 221);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(570L);
        this.setCooldown(1.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
    }
}
