package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrangeBomb extends AttackSkill {
    public StrangeBomb() {
        this.setName("스트레인지 봄");
        this.setDamage(400.0);
        this.setDelayByAttackSpeed(900L);
        this.setAttackCount(12L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
