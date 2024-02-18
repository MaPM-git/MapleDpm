package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GodOfTheSea extends AttackSkill {
    public GodOfTheSea() {
        this.setName("해신강림");
        this.setAttackCount(7L);
        this.setDamage(860.0);
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(45.0);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
