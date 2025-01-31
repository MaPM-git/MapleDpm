package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GodOfTheSea extends AttackSkill {
    public GodOfTheSea() {
        this.setName("해신강림");
        this.setAttackCount(7L * 2);
        this.setDamage(1380.0);
        this.setDelayByAttackSpeed(540L);
        this.setCooldown(45.0);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
